plugins {
    Plugins.apply {
        id(androidLibrary)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
    }
}

android {
    namespace = "com.example.data"
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    // domain
    implementation(project(":domain"))
}