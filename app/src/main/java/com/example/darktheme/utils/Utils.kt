package com.example.darktheme.utils

import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.*
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
fun showAltert(context: Context, callbacks: MutableList<()->Unit>){
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setMessage(MESSAGE_NIGHT_MODE)
    builder.setPositiveButton(POSITIVE_BT_TXT) { _, _ ->
        callbacks[0]()
    }
    //neutral
    builder.setNeutralButton(NEUTRAL_BT_TXT) { _, _ ->
        callbacks[1]()
    }
    //close
    builder.setNegativeButton(NEGATIVE_BT_TXT) { _, _ ->
        callbacks[2]()
    }
    builder.show()
}
