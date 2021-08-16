package com.moyuchen.study_jetpack.databinding.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 *@Author zhangyabo
 *@Date  2021/6/21
 *@Des   @Ignore 此注解表示，属性不存在room表中
 **/
@Entity(tableName = "student")
class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    var id: Int = 0;

    @ColumnInfo(name = "name",typeAffinity = ColumnInfo.TEXT)
    var name:String = ""


    @ColumnInfo(name="age",typeAffinity = ColumnInfo.INTEGER)
    var age:Int = 0

    @Ignore
    constructor(id: Int, name: String, age: Int) {
        this.id = id
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

}