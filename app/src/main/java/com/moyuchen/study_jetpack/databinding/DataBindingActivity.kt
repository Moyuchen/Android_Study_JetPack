package com.moyuchen.study_jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.moyuchen.study_jetpack.R

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_data_binding
        ) as ActivityDataBindingBinding
        var entity = DataBindingEntity("")
        entity.name = "张三"
        entity.position = "北京"
        dataBinding.dataBindingEntity = entity


    }
}