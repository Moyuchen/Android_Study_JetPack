package com.moyuchen.study_jetpack

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner

/**
 *@Author zhangyabo
 *@Date  2021/5/25
 *@Des
 **/
class StudyJetPackApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())

    }

}