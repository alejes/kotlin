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

package org.jetbrains.kotlin.android.configure;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/configuration/android-gradle")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ConfigureProjectTestGenerated extends AbstractConfigureProjectTest {
    public void testAllFilesPresentInAndroid_gradle() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/configuration/android-gradle"), Pattern.compile("(\\w+)_before\\.gradle$"), true);
    }

    @TestMetadata("androidStudioDefault_before.gradle")
    public void testAndroidStudioDefault() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/androidStudioDefault_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("androidStudioDefaultShapshot_before.gradle")
    public void testAndroidStudioDefaultShapshot() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/androidStudioDefaultShapshot_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("buildConfigs_before.gradle")
    public void testBuildConfigs() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/buildConfigs_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("emptyDependencyList_before.gradle")
    public void testEmptyDependencyList() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/emptyDependencyList_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("emptyFile_before.gradle")
    public void testEmptyFile() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/emptyFile_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("helloWorld_before.gradle")
    public void testHelloWorld() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/helloWorld_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("libraryFile_before.gradle")
    public void testLibraryFile() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/libraryFile_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("missedApplyAndroidStatement_before.gradle")
    public void testMissedApplyAndroidStatement() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/missedApplyAndroidStatement_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("missedBuildscriptBlock_before.gradle")
    public void testMissedBuildscriptBlock() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/missedBuildscriptBlock_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("missedRepositoriesInBuildscriptBlock_before.gradle")
    public void testMissedRepositoriesInBuildscriptBlock() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/missedRepositoriesInBuildscriptBlock_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("productFlavor_before.gradle")
    public void testProductFlavor() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/productFlavor_before.gradle");
        doTestAndroidGradle(fileName);
    }

    @TestMetadata("idea/testData/configuration/android-gradle/gradleExamples")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class GradleExamples extends AbstractConfigureProjectTest {
        public void testAllFilesPresentInGradleExamples() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/configuration/android-gradle/gradleExamples"), Pattern.compile("(\\w+)_before\\.gradle$"), true);
        }

        @TestMetadata("gradleExample0_before.gradle")
        public void testGradleExample0() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample0_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample18_before.gradle")
        public void testGradleExample18() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample18_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample22_before.gradle")
        public void testGradleExample22() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample22_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample44_before.gradle")
        public void testGradleExample44() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample44_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample5_before.gradle")
        public void testGradleExample5() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample5_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample50_before.gradle")
        public void testGradleExample50() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample50_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample58_before.gradle")
        public void testGradleExample58() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample58_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample65_before.gradle")
        public void testGradleExample65() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample65_before.gradle");
            doTestAndroidGradle(fileName);
        }

        @TestMetadata("gradleExample8_before.gradle")
        public void testGradleExample8() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/configuration/android-gradle/gradleExamples/gradleExample8_before.gradle");
            doTestAndroidGradle(fileName);
        }
    }
}