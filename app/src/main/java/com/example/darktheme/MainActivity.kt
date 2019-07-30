package com.example.darktheme

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.darktheme.ui.main.PageViewModel
import com.example.darktheme.utils.DayNightHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import androidx.lifecycle.Observer
import com.example.darktheme.utils.animeX
import com.example.darktheme.utils.showAltert

class MainActivity : AppCompatActivity() {
    private val dayNightHelper by inject<DayNightHelper>()
    private val pageViewModel: PageViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        pageViewModel.dayNight.observe(this, Observer {
            section_label.text = it
        })
        pageViewModel.animeView.observe(this, Observer {
            animeView()
        })
        fab.setOnClickListener { view ->

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
    private fun animeView() {
        textView.animeX(50F, 500).addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {textView.animeX(-100F, 500)}
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {}
        })
    }
    fun changeMode(view: View){
        showAltert(this, mutableListOf(::nightOn, ::nightDefault, ::nightOff))
    }

    private fun nightOn() = dayNightHelper.nightOn()
    private fun nightOff() = dayNightHelper.nightOff()
    private fun nightDefault() = dayNightHelper.nightDefault()
}