package com.moyuchen.study_jetpack.databinding.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

/**
 *@Author YaBo Zhang
 *@Date  2021/8/17
 *@Description
 **/
class StudentRepository {
    private var studentDao: StudentDao? = null

    constructor(context: Context) {
        this.studentDao = StudentDataBase.instance(context).getStudentDao()
    }

    fun insertStudent(student: Student) {
        GlobalScope.launch {
            async {
                studentDao?.insertStudent(Student("张三", 29))
            }
        }

    }

    fun updateStudent(student: Student) {
        GlobalScope.launch {
            async {
                studentDao?.updateStudent(Student(4, "李四", 20))
            }
        }

    }

    fun deleteStudent(student: Student) {
        GlobalScope.launch {
            async {
                studentDao?.deleteStudent(Student(1, "张三", 29))
            }
        }
    }

    fun getStudentList(): LiveData<List<Student>>? {
//        var student: LiveData<List<Student>>? = MutableLiveData<List<Student>>()
//        GlobalScope.launch {
//            student =
//                withContext(Dispatchers.Default) {
//                     studentDao?.getStudents()
//                }
//        }
        return studentDao?.getStudents()
    }


}