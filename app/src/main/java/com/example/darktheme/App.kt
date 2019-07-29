package com.example.darktheme

import android.app.Application
import com.example.darktheme.di.dayNightHelperModule
import com.example.darktheme.di.logManagerModule
import com.example.darktheme.di.sharedPreferencesModule
import com.example.darktheme.di.viewModelModules
import com.example.darktheme.utils.DayNightHelper
import com.example.darktheme.utils.LogManager
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.startKoin

class App : Application(){
    private val dayNightHelper by lazy{
        inject <DayNightHelper>()
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this,
            listOf(logManagerModule, sharedPreferencesModule, dayNightHelperModule, viewModelModules )
        )

        //setupDayNight
        initializeDayNightHelper()
    }
    fun initializeDayNightHelper(){
        dayNightHelper.value.init()
    }
}