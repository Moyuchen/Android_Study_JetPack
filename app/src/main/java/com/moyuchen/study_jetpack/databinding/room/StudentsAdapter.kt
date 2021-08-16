package com.moyuchen.study_jetpack.databinding.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.moyuchen.study_jetpack.R
import com.moyuchen.study_jetpack.databinding.ItemStudentBinding
import kotlinx.android.synthetic.main.item_student.view.*
import org.w3c.dom.Text

/**
 *@Author YaBo Zhang
 *@Date  2021/8/16
 *@Description
 **/
class StudentsAdapter(var data:MutableList<Student>) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemStudentBinding:ItemStudentBinding? = null
        constructor(itemStudentBinding: ItemStudentBinding):this(itemStudentBinding.root){
            this.itemStudentBinding = itemStudentBinding
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemStudentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_student,
            parent,
            false
        ) as ItemStudentBinding
        return StudentViewHolder(itemStudentBinding)
    }

    override fun getItemCount(): Int {
        return when{
            data.isNullOrEmpty() -> 0
            else -> data.size
        }
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.itemStudentBinding?.let {
            it.student = data[position]
            it.executePendingBindings()
        }
    }
}