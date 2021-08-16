package com.moyuchen.study_jetpack.databinding.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *@Author zhangyabo
 *@Date  2021/6/21
 *@Des
 **/

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDataBase : RoomDatabase() {
    companion object {

         private const val DATABASE_NAME = "student.db"

        fun instance(context: Context): StudentDataBase {
            val instance: StudentDataBase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                Room.databaseBuilder(context.applicationContext,StudentDataBase::class.java, DATABASE_NAME).build()
            }
            return instance
        }

    }

    public abstract fun getStudentDao():StudentDao

}


