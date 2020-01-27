package com.android.mylearning.fragmentpageradapter

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.android.mylearning.R
import kotlinx.android.synthetic.main.fragment_vollyball.*

class VollyballFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Handler().postDelayed(Runnable { volleyBall.text="Hello Moto"
            Toast.makeText(this.context, "Hello", Toast.LENGTH_SHORT).show()
        },2000)
        return inflater.inflate(R.layout.fragment_vollyball, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDetach() {
        super.onDetach()
    }

    fun newInstance(): Fragment {
        return VollyballFragment()
    }

}
