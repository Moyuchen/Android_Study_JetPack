package com.moyuchen.study_jetpack.databinding.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *@Author YaBo Zhang
 *@Date  2021/8/17
 *@Description
 **/
class StudentViewModel(application: Application) : AndroidViewModel(application) {
    var studentRepository:StudentRepository? = null
    init {
        studentRepository = StudentRepository(application)
    }

    fun insertStudent(student: Student){
        studentRepository?.insertStudent(student)
    }
    fun deleteStudent(student: Student){
        studentRepository?.deleteStudent( student)
    }
    fun updateStudent(student: Student){
        studentRepository?.updateStudent(student)
    }

    fun getStudentList(): LiveData<List<Student>>?{
        return studentRepository?.getStudentList()

    }



}