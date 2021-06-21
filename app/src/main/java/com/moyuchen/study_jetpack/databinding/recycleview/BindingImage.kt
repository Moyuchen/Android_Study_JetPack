package com.moyuchen.study_jetpack.databinding.recycleview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *@Author zhangyabo
 *@Date  2021/6/14
 *@Des
 **/
object BindingImage {
    @JvmStatic
    @BindingAdapter("android:imageHead")
    fun setNetWorkImage(imageView: ImageView, url: String?) {

        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context).load(url).asBitmap().into(imageView)
        }


    }
}