package com.android.mylearning.builderpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.mylearning.R

class BuilderPatternActivity : AppCompatActivity() {
    var builderPattern  : BuilderPattern?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder_pattern)
        builderPattern()

        Log.d("!!  pattern" , builderPattern?.getUserId().toString())
    }

    private fun builderPattern(){
        builderPattern  = BuilderPattern.Companion.Builder()
            .userId("1000000")
            .userName("")
            .vehicle("")
            .type("")
            .build()
        builderPattern?.mandatory=true
    }

}
