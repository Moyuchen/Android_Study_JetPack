package com.moyuchen.study_jetpack.databinding.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 *@Author zhangyabo
 *@Date  2021/6/21
 *@Des
 **/

@Database(entities = [Student::class], version = 2, exportSchema = false)
abstract class StudentDataBase : RoomDatabase() {
    companion object {

         private const val DATABASE_NAME = "student.db"

        fun instance(context: Context): StudentDataBase {
            val instance: StudentDataBase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                Room.databaseBuilder(context.applicationContext,StudentDataBase::class.java, DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2).build()
            }
            return instance
        }

        final val MIGRATION_1_2:Migration = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1")
            }

        }

    }

    public abstract fun getStudentDao():StudentDao

}


