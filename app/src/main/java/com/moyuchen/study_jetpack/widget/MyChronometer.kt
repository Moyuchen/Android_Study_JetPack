package com.moyuchen.study_jetpack.widget

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 *@Author zhangyabo
 *@Date  2021/5/24
 *@Des
 **/
class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    LifecycleObserver {

    var elapsedTime:Long = 0
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startTime() {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseTime(){
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }

}