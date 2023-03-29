plugins {
    Plugins.apply {
        id(application)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
    }
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    // ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {
    Dependencies.UiComponents.apply {
        // Core
        implementation(core)
        // AppCompat
        implementation(appCompat)
        // Material Design
        implementation(material)
        // UI Components
        implementation(constraint)
        implementation(legacy)
        implementation(lifecycle)
    }

    Dependencies.Activity.apply {
        // Activity
        implementation(activity)
    }

    Dependencies.Fragment.apply {
        // Fragment
        implementation(fragment)
    }

    Dependencies.Retrofit.apply {
        // Retrofit
        implementation(retrofit)
        implementation(gsonConvertor)
    }

    Dependencies.OkHttpClient.apply {
        // OkHttp Client
        implementation(platform(bomHttp))
        implementation(okHttp)
        implementation(httpInterceptor)
    }

    Dependencies.Hilt.apply {
        // Hilt
        implementation(hilt)
        kapt(hiltCompiler)
    }

    Dependencies.Navigation.apply {
        // Navigation
        implementation(navigationFragment)
        implementation(navigation)
    }

    Dependencies.Lifecycles.apply {
        // Lifecycles
        implementation(lifecycles)
        implementation(runtimeLifecycles)
    }

    Dependencies.ViewBinding.apply {
        // ViewBindingPropertyDelegate
        implementation(viewBinding)
    }

    Dependencies.Glide.apply {
        // Glide
        implementation(glide)
        annotationProcessor(glideCompiler)
    }

    Dependencies.Paging3.apply {
        // Paging 3
        implementation(paging3)
    }

    // data
    implementation(project(":data"))

    // domain
    implementation(project(":domain"))

    //presentation
    implementation(project(":presentation"))
}