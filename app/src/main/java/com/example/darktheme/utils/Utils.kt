package com.example.darktheme.utils

import android.animation.Animator
import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext


fun fixRateTimer(initialDelay: Long = 0, delayed: Long, scope: CoroutineScope = GlobalScope, context: CoroutineContext = Dispatchers.Default, block: ()-> Unit)
        : Job = scope.launch(context){

    delay(initialDelay)
    do{
        withContext(Dispatchers.Main){
            block()
        }
        delay(delayed)
    }while (true)
}

fun View.animeX(value: Float, delay: Long = 1000) : ObjectAnimator{
    return ObjectAnimator.ofFloat(this, "translationX", value).apply {
        duration = delay
        start()
    }
}
