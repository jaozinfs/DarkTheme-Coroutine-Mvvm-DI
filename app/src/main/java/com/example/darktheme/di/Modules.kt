package com.example.darktheme.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.darktheme.ui.main.PageViewModel
import com.example.darktheme.utils.DayNightHelper
import com.example.darktheme.utils.LogManager
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val sharedPreferencesModule = module {
    factory {
        PreferenceManager.getDefaultSharedPreferences(androidApplication())
    }
}

val logManagerModule = module {
    single{
        LogManager()
    }
}

val dayNightHelperModule = module {
    single {
        DayNightHelper(get(), get())
    }
}

val viewModelModules = module {
    viewModel {
        PageViewModel(get())
    }
}