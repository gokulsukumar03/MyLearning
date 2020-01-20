package com.android.mylearning.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R


class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

    private fun hashMapTesting() {

        var mHashMap = HashMap<Int, NavModel>()
        mHashMap[1] = NavModel("Sukumar")
        mHashMap[2] = NavModel("Hari")
        val it: Iterator<Any> = mHashMap.entries.iterator()
        while (it.hasNext()) {
            val pairs = it.next() as Map.Entry<*, *>
            println(pairs.key.toString() + " = " + pairs.value)
        }
    }
}
