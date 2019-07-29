

object Versions{
    //coroutines
    const val coroutineCoreVersion = "1.2.1"
    const val coroutineVersion = "1.1.1"

    //Koin
    const val koinVersion = "1.0.1"
    const val koinViewModelVersion = "1.0.2"

    //Jetpack
    const val roomVersion = "2.1.0-alpha03"
    const val lifecycle = "2.1.0-beta01"
    const val preferenceVersion = "1.1.0-rc01"

    //implementation "1.1.0-rc01"
}

object Libs{
    //koin
    val koin = "org.koin:koin-android:${Versions.koinVersion}"
    val koinViewModel =  "org.koin:koin-androidx-viewmodel:${Versions.koinViewModelVersion}"

    //coroutines
    val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    //jetpack
    val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomCoroutine = "androidx.room:room-coroutines:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val lifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val preference = "androidx.preference:preference-ktx:${Versions.preferenceVersion}"
}