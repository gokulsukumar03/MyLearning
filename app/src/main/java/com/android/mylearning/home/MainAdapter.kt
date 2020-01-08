package com.android.mylearning.home

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mylearning.R
import kotlinx.android.synthetic.main.adapter_main.view.*

class MainAdapter(private val learningList : ArrayList<LearningDto>, val onClickListener: (Class<Any>)->Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.adapter_main,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return learningList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            mLeaningTitle.text=learningList[position].title
            mRelativeLayout.setOnClickListener {
                learningList[position].activity?.let {
                    onClickListener(learningList[position].activity!!)
                }
            }
        }
    }
    class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view)
}