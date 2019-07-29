package com.example.darktheme.ui.main

import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.lifecycle.*
import com.example.darktheme.utils.DayNightHelper
import com.example.darktheme.utils.SingleLiveEvent
import com.example.darktheme.utils.fixRateTimer
import kotlinx.coroutines.Job

class PageViewModel(private val dayNightHelper: DayNightHelper) : ViewModel() {
     //observe day night data
    private val _dayNightLiveData = MediatorLiveData<Int>()
    private val dayNightLiveData: LiveData<Int> = _dayNightLiveData
    private var jobAnime: Job? = null

    val animeView = SingleLiveEvent<Any?>()

    val dayNight: LiveData<String> = Transformations.map(
        dayNightHelper.getMode()
    ) {
        verifyObjectDayNight(it)
    }
    private fun verifyObjectDayNight(data: Int): String = when(data){
        MODE_NIGHT_YES -> "Night On"
        MODE_NIGHT_NO -> "Night Off"
        else -> "Default"
    }
    fun startAnimation() {
        jobAnime?.let{
            jobAnime!!.cancel()
        }
        jobAnime = fixRateTimer(delayed = 5000){
            animeView.call()
        }
    }
}