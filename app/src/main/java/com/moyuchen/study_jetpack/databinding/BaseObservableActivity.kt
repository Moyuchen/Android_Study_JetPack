package com.moyuchen.study_jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.moyuchen.study_jetpack.R

class BaseObservableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_base_observable)
        var baseObservableBingding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_base_observable
        ) as ActivityBaseObservableBinding
        baseObservableBingding.baseObservableModel = BaseObservableMedel()
    }
}