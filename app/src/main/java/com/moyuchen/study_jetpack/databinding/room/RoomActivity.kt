package com.moyuchen.study_jetpack.databinding.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.moyuchen.study_jetpack.R
import com.moyuchen.study_jetpack.databinding.ActivityRoomBinding
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity(), View.OnClickListener {
    var studentViewModel: StudentViewModel? = null
    var mStudentAdapter: StudentsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_room)
        val roomBindingView =
            DataBindingUtil.setContentView(this, R.layout.activity_room) as ActivityRoomBinding
        roomBindingView.dateRecycle.layoutManager = LinearLayoutManager(this)
        mStudentAdapter = StudentsAdapter(mutableListOf())
        roomBindingView.dateRecycle.adapter = mStudentAdapter

        roomBindingView.add.setOnClickListener(this)
        roomBindingView.update.setOnClickListener(this)
        roomBindingView.delete.setOnClickListener(this)
        roomBindingView.get.setOnClickListener(this)

//        val mStudentDataBase = StudentDataBase.instance(this)
//        mStudentDao = mStudentDataBase.getStudentDao()


        studentViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)
        studentViewModel?.getStudentList()!!.observe(this, Observer {
            runOnUiThread {
                mStudentAdapter?.data = it.toMutableList()
                mStudentAdapter?.notifyDataSetChanged()
            }
        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add -> {
                studentViewModel?.insertStudent(Student("张三", 29))
            }
            R.id.delete -> {
                studentViewModel?.deleteStudent(Student(1, "张三", 29))
            }
            R.id.update -> {
                studentViewModel?.updateStudent(Student(4, "李四", 20))
            }
            R.id.get -> {
//                GlobalScope.launch {
//                    val student =
//                        withContext(Dispatchers.Default) {
//                            val students = studentViewModel?.getStudents()
//                            students
//                        }
//
//                    runOnUiThread {
//                        student?.let {
//                            mStudentAdapter?.data = it.toMutableList()
//                            mStudentAdapter?.notifyDataSetChanged()
//                        }
//                    }
//                }
            }

        }
    }
}