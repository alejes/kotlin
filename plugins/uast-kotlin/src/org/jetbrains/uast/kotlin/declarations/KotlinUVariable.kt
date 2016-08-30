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

package org.jetbrains.uast.kotlin

import com.intellij.psi.*
import org.jetbrains.kotlin.asJava.elements.KtLightElement
import org.jetbrains.kotlin.psi.KtVariableDeclaration
import org.jetbrains.uast.*
import org.jetbrains.uast.expressions.UReferenceExpression
import org.jetbrains.uast.expressions.UTypeReferenceExpression
import org.jetbrains.uast.java.*

abstract class AbstractKotlinUVariable : AbstractJavaUVariable() {
    override val uastInitializer: UExpression?
        get() {
            val kotlinOrigin = (psi as? KtLightElement<*, *>)?.kotlinOrigin ?: return null
            val initializerExpression = (kotlinOrigin as? KtVariableDeclaration)?.initializer ?: return null
            return languagePlugin.convertExpressionOrEmpty(initializerExpression, this)
        }
}

class KotlinUVariable(
        psi: PsiVariable,
        override val languagePlugin: UastLanguagePlugin,
        override val containingElement: UElement?
) : AbstractKotlinUVariable(), UVariable, PsiVariable by psi {
    override val psi = unwrap(psi)

    override val uastAnnotations by lz { psi.annotations.map { SimpleUAnnotation(it, languagePlugin, this) } }
    override val typeReference by lz { languagePlugin.convertOpt<UTypeReferenceExpression>(psi.typeElement, this) }
    
    companion object {
        fun create(psi: PsiVariable, languagePlugin: UastLanguagePlugin, containingElement: UElement?): UVariable {
            return when (psi) {
                is PsiEnumConstant -> KotlinUEnumConstant(psi, languagePlugin, containingElement)
                is PsiLocalVariable -> KotlinULocalVariable(psi, languagePlugin, containingElement)
                is PsiParameter -> KotlinUParameter(psi, languagePlugin, containingElement)
                is PsiField -> KotlinUField(psi, languagePlugin, containingElement)
                else -> KotlinUVariable(psi, languagePlugin, containingElement)
            }
        }
    }
}

open class KotlinUParameter(
        psi: PsiParameter,
        override val languagePlugin: UastLanguagePlugin,
        override val containingElement: UElement?
) : AbstractKotlinUVariable(), UParameter, PsiParameter by psi {
    override val psi = unwrap(psi) as PsiParameter
}

open class KotlinUField(
        psi: PsiField,
        override val languagePlugin: UastLanguagePlugin,
        override val containingElement: UElement?
) : AbstractKotlinUVariable(), UField, PsiField by psi {
    override val psi = unwrap(psi) as PsiField
}

open class KotlinULocalVariable(
        psi: PsiLocalVariable,
        override val languagePlugin: UastLanguagePlugin,
        override val containingElement: UElement?
) : AbstractKotlinUVariable(), ULocalVariable, PsiLocalVariable by psi {
    override val psi = unwrap(psi) as PsiLocalVariable
}

open class KotlinUEnumConstant(
        psi: PsiEnumConstant,
        override val languagePlugin: UastLanguagePlugin,
        override val containingElement: UElement?
) : AbstractKotlinUVariable(), UEnumConstant, PsiEnumConstant by psi {
    override val psi = unwrap(psi) as PsiEnumConstant

    override val isUsedAsExpression: Boolean
        get() = true

    override val kind: org.jetbrains.uast.UastCallKind
        get() = org.jetbrains.uast.UastCallKind.CONSTRUCTOR_CALL
    override val receiver: org.jetbrains.uast.UExpression?
        get() = null
    override val receiverType: PsiType?
        get() = null
    override val methodReference: UReferenceExpression?
        get() = null
    override val classReference: UReferenceExpression?
        get() = null
    override val typeArgumentCount: Int
        get() = 0
    override val typeArguments: List<PsiType>
        get() = emptyList()
    override val valueArgumentCount: Int
        get() = psi.argumentList?.expressions?.size ?: 0

    override val valueArguments by lz {
        psi.argumentList?.expressions?.map { languagePlugin.convertExpressionOrEmpty(it, this) } ?: emptyList()
    }

    override val returnType: PsiType?
        get() = psi.type

    override fun resolve() = psi.resolveMethod()

    override val methodName: String?
        get() = null
}

@Suppress("UNCHECKED_CAST")
private tailrec fun <T : PsiVariable> unwrap(psi: T): PsiVariable = if (psi is UVariable) unwrap(psi.psi) else psi