package com.moyuchen.study_jetpack.databinding.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.moyuchen.study_jetpack.R
import com.moyuchen.study_jetpack.databinding.ActivityRoomBinding
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity(), View.OnClickListener {
    var mStudentDao: StudentDao? = null
    var mStudentAdapter:StudentsAdapter? = null
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

        val mStudentDataBase = StudentDataBase.instance(this)
        mStudentDao = mStudentDataBase.getStudentDao()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add -> {
                GlobalScope.launch {
                    async {
                        mStudentDao?.insertStudent(Student("张三", 29))
                    }


                }


            }
            R.id.delete -> {
                GlobalScope.launch {
                    async {
                        mStudentDao?.deleteStudent(Student(1,"张三",29))
                    }
                }

            }
            R.id.update -> {
                GlobalScope.launch {
                    async {
                        mStudentDao?.updateStudent(Student(4,"李四",20))
                    }
                }
            }
            R.id.get -> {
                GlobalScope.launch {
                    val student =
                        withContext(Dispatchers.Default) {
                            val students = mStudentDao?.getStudents()
                            students
                        }

                    runOnUiThread {
                        student?.let {
                            mStudentAdapter?.data = it.toMutableList()
                            mStudentAdapter?.notifyDataSetChanged()
                        }
                    }


                }
            }

        }
    }
}