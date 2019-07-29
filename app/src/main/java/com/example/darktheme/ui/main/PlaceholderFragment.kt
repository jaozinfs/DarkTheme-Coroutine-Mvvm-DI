package com.example.darktheme.ui.main

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.darktheme.R
import com.example.darktheme.utils.DayNightHelper
import com.example.darktheme.utils.animeX
import com.example.darktheme.utils.fixRateTimer
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private val pageViewModel: PageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel.startAnimation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)


        pageViewModel.dayNight.observe(this, Observer {
            section_label.text = it
        })
        pageViewModel.animeView.observe(this, Observer {
            animeView()
        })

        return root
    }

    private fun animeView() {
       textView.animeX(50F, 500).addListener(object : Animator.AnimatorListener{
           override fun onAnimationRepeat(p0: Animator?) {}
           override fun onAnimationEnd(p0: Animator?) {textView.animeX(-100F, 500)}
           override fun onAnimationCancel(p0: Animator?) {}
           override fun onAnimationStart(p0: Animator?) {}
       })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }


}