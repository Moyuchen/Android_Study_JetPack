package com.moyuchen.study_jetpack

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 *@Author zhangyabo
 *@Date  2021/5/25
 *@Des  监听整个应用生命周期，与单个activity 无关
 * 主要用于Application类中
 **/
class ApplicationObserver : LifecycleObserver {

    /**
     * 此方法只执行一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() = println("ApplicationObserver => onCreate()")

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() = println("ApplicationObserver => onStart()")

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() = println("ApplicationObserver => onResume()")

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() = println("ApplicationObserver => onPause()")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() = println("ApplicationObserver => onStop()")

    /**
     * 此方法一次也不执行
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() = println("ApplicationObserver => onDestory()")
}