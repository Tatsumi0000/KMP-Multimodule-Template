import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    // FIXME: version
    id("org.jetbrains.kotlin.multiplatform") version ""
    id("org.jetbrains.compose") version ""
    id("org.jetbrains.kotlin.plugin.compose") version ""
    id("com.android.library") version ""
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            // FIXME: baseName
            baseName = "Hoge"
            isStatic = true
        }
    }

    js(IR) {
        browser()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        // FIXME: moduleName
        moduleName = "Hoge"
        browser()
        binaries.library()
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }
    }
}

// FIXME: android settings(namespace, compileSdk, minSdk, javaVersion, and so on...)
android {
    namespace = "com.example.hoge"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeCompiler {
        enableStrongSkippingMode = true
    }
}
