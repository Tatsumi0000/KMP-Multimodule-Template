# KMP-Multimodule-Template

This repository is a template for implementing multi-modules in Kotlin Multiplatform(KMP).

| tool                    | version |
| ----------------------- | ------- |
| Kotlin                  | 2.0.0   |
| org.jetbrains.compose   | 1.6.10  |
| com.android.application | 8.3.0   |

## 👩‍💻 How to use?

1. Clone repository

```
git clone git@github.com:Tatsumi0000/KMP-Multimodule-Template.git
```

2. Copy directory hoge to directory KMP project.
3. Rename `package_name` and `hoge` folder name.
4. Add the module include to settings.gradle.kts in the KMP project.

```kotlin
// settings.gradle.kts(your KMP project)
include(":hoge")
```

5. Fix build.gradle.kts. (FIXME is written where corrections are needed)
6. Load the module in the module you want to use in the build.gradle.kts in your KMP project.

```kotlin
// build.gradle.kts(:composeApp)
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":hoge"))
        }
}

```

An example implementation can be found in [this repository](https://github.com/Tatsumi0000/nct-deck).


## ☝ Points
It appears that the directory name must contain commonMain.
Class is recognized by the Android and iOS packages even though it does not contain commonMain, but not by commonMain(:composeApp).
