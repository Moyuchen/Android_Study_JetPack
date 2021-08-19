package com.moyuchen.study_jetpack.databinding.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *@Author zhangyabo
 *@Date  2021/6/21
 *@Des
 **/

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(vararg student: Student)

    @Delete
    fun deleteStudent(vararg  student: Student)

    @Update
    fun updateStudent(vararg  student: Student)

    @Query("SELECT * FROM student")
    fun getStudents():LiveData<List<Student>>


}