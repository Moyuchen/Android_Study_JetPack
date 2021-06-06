package com.moyuchen.study_jetpack.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *@Author zhangyabo
 *@Date  2021/6/3
 *@Des
 **/
internal object OwnerImageAdapter {

    @JvmStatic
     @BindingAdapter("image","defaultLocalImage",requireAll = false)
     fun setNetWorkImage(imageView: ImageView,url:String?,localImage:Int){

        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context).load(url).asBitmap().into(imageView)
        }else{
            imageView.setImageResource(localImage)
        }


     }

}