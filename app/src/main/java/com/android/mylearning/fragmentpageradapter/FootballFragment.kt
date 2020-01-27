package com.android.mylearning.fragmentpageradapter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.mylearning.R

/**
 * A simple [Fragment] subclass.
 */
class FootballFragment : Fragment() {

    fun newInstance() : FootballFragment{
        return FootballFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_football, container, false)
    }


}
