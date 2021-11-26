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

@Database(entities = [Student::class], version = 3, exportSchema = true)
abstract class StudentDataBase : RoomDatabase() {
    companion object {

        private const val DATABASE_NAME = "student.db"

        fun instance(context: Context): StudentDataBase {
            val instance: StudentDataBase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                Room.databaseBuilder(context.applicationContext,StudentDataBase::class.java, DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
//                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

        private final val MIGRATION_1_2:Migration = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1")
            }

        }

        private final val MIGRATION_2_3:Migration = object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
//
                database.execSQL("CREATE TABLE temp_student ("+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                        "name TEXT NOT NULL,"+
                        "age INTEGER NOT NULL,"+
                        "sex TEXT NOT NULL DEFAULT 'M')");
                database.execSQL("INSERT INTO temp_student (name,age,sex)"+
                "SELECT name,age,sex FROM student")
                database.execSQL("DROP TABLE student")
                database.execSQL("ALTER TABLE temp_student RENAME TO student")
            }

        }

    }

    public abstract fun getStudentDao():StudentDao

}


