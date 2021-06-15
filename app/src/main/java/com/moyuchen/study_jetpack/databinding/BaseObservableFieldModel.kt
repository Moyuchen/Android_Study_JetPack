package com.moyuchen.study_jetpack.databinding

import android.provider.ContactsContract
import androidx.databinding.ObservableField

/**
 *@Author zhangyabo
 *@Date  2021/6/6
 *@Des
 **/
class BaseObservableFieldModel {
    var field:ObservableField<DataBindingEntity>? = null
    constructor(){
        field = ObservableField()
        field?.set(DataBindingEntity("Zhangsan"))
    }

    fun getName():String{
        return field!!.get()!!.name
    }
    fun  setName(name:String){
        field?.get()?.name = name

    }
}