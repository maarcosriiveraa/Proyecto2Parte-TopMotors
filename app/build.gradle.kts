plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.proyecto_2trim_topmotors"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.proyecto_2trim_topmotors"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    val nav_version = "2.5.3"
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:11.0.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}