package com.example.darktheme.utils

import android.util.Log
import java.util.*
import java.util.logging.LogManager
import kotlin.collections.ArrayList

class LogManager{
    private var list: ArrayList<String> = ArrayList()
    private val LOGSTART = "Start Log..."
    private val LOGEND = "End Log..."
    private val LOGTAG = "LogManager"

    init {
        list.add(LOGSTART)
    }

    fun log(className: String, message: String){
        val m = "$className - $message \n ${Calendar.getInstance().time}"
        Log.d(LOGTAG, m)
        list.add(m)
    }

    fun showLogs(){
        list.forEach {
            Log.d(LOGTAG, it)
        }
    }

}