/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.uast

import com.intellij.openapi.application.ApplicationManager
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.codeInsight.DescriptorToSourceUtilsIde
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.psi.psiUtil.visibilityModifierType
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.uast.kinds.KotlinUastVisibilities
import org.jetbrains.uast.*

private val MODIFIER_MAP = mapOf(
        UastModifier.ABSTRACT to KtTokens.ABSTRACT_KEYWORD,
        UastModifier.INNER to KtTokens.INNER_KEYWORD
)

internal fun KtDeclaration.getVisibility() = when (visibilityModifierType()) {
    KtTokens.PRIVATE_KEYWORD -> UastVisibility.PRIVATE
    KtTokens.PROTECTED_KEYWORD -> UastVisibility.PROTECTED
    KtTokens.INTERNAL_KEYWORD -> KotlinUastVisibilities.INTERNAL
    else -> UastVisibility.PUBLIC
}

internal fun KtModifierListOwner.hasModifier(modifier: UastModifier): Boolean {
    val javaModifier = MODIFIER_MAP[modifier] ?: return false
    return hasModifier(javaModifier)
}

internal fun <T> runReadAction(action: () -> T): T {
    return ApplicationManager.getApplication().runReadAction<T>(action)
}

internal fun KtElement?.resolveCallToUDeclaration(context: UastContext): UDeclaration? {
    if (this == null) return null
    val resolvedCall = this.getResolvedCall(analyze(BodyResolveMode.PARTIAL)) ?: return null
    val source = DescriptorToSourceUtilsIde.getAnyDeclaration(project, resolvedCall.resultingDescriptor) ?: return null
    return context.convert(source) as? UDeclaration
}

internal fun KtElement?.resolveElementToUDeclaration(context: UastContext): UDeclaration? {
    if (this == null) return null
    val bindingContext = analyze(BodyResolveMode.PARTIAL)
    val descriptor = bindingContext[BindingContext.DECLARATION_TO_DESCRIPTOR, this] ?: return null
    val source = DescriptorToSourceUtilsIde.getAnyDeclaration(project, descriptor) ?: return null
    return context.convert(source) as? UDeclaration
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun String?.orAnonymous(kind: String = ""): String {
    return this ?: "<anonymous" + (if (kind.isNotBlank()) " $kind" else "") + ">"
}

internal fun KtAnnotated.getUastAnnotations(parent: UElement) = annotationEntries.map { KotlinUAnnotation(it, parent) }

internal fun <T> singletonListOrEmpty(element: T?) = if (element != null) listOf(element) else emptyList<T>()