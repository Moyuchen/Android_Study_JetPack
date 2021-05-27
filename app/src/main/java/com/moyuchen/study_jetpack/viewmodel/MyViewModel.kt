package com.moyuchen.study_jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *@Author zhangyabo
 *@Date  2021/5/27
 *@Des
 **/
class MyViewModel : ViewModel() {
    var progress: MutableLiveData<Int>? = MutableLiveData()
//        get() {
//            if(null == progress) progress = MutableLiveData()
//            progress?.value = 0
//            return progress
//        }


}