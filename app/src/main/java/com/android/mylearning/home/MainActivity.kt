package com.android.mylearning.home
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.mylearning.R
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainViewModel : MainViewModel?=null
    private var mainAdapter : MainAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel = MainViewModel()
        mainViewModel?.loadLearning()
        mainViewModel?.mLearningMutableLiveData?.observe(this, Observer {
            it?.let {
                learnings->
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mainAdapter = MainAdapter(learnings) {
                    startActivity(Intent(this, it))

                }
                mRecyclerView.adapter = mainAdapter
            }
        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
