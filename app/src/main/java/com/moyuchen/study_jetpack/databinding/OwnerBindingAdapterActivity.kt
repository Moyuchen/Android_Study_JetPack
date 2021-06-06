package com.moyuchen.study_jetpack.databinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.moyuchen.study_jetpack.R

class OwnerBindingAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_owner_binding_adapter)
        var mOwnerBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_owner_binding_adapter
        ) as ActivityOwnerBindingAdapterBinding


        mOwnerBinding.netWorkImage =
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201107%2F23%2F20110723200245_2HU4e.thumb.700_0.jpg&refer=http%3A%2F%2Fcdn.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625323582&t=b468c5ff7bea4bf5c7f5ec29cfb2399b"
        mOwnerBinding.localImage = R.mipmap.ic_launcher


    }
}