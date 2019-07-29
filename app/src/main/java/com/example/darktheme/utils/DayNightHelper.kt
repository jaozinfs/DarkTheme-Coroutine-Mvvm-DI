package com.example.darktheme.utils
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DayNightHelper(private val sharedPref: SharedPreferences, private val logManager: LogManager){
    private val SHAREDPREFTAG = "daynightpref"
    private val valueLiveData = MutableLiveData<Int>()


    fun init() {
        logManager.log(javaClass.name, "start daynight")
        changeMode(sharedPref.getInt(SHAREDPREFTAG, 3))
    }


    fun changeMode(mode: Int){
        if(getDefaultNightMode() == mode)
            return
        else {
            sharedPref.edit().putInt(SHAREDPREFTAG, mode).apply()
            valueLiveData.value = mode
            update(mode)
        }
    }

    private fun update(mode: Int) = when(mode){

        MODE_NIGHT_YES ->{
            setDefaultNightMode(MODE_NIGHT_YES)
            logManager.log(javaClass.name, "change MODE_NIGHT_YES")
        }
        MODE_NIGHT_NO -> run {
            setDefaultNightMode(MODE_NIGHT_NO)
            logManager.log(javaClass.name, "change MODE_NIGHT_NO")
        }
        else->{
            setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
            logManager.log(javaClass.name, "MODE_NIGHT_FOLLOW_SYSTEM MODE_NIGHT_YES")
        }
    }

    fun getMode() : LiveData<Int> = valueLiveData

}