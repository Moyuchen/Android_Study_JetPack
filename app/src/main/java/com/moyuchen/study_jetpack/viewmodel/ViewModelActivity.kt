package com.moyuchen.study_jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moyuchen.study_jetpack.R

/**
 * ViewModel+LiveData实现fragment之间通信
 */

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
    }
}