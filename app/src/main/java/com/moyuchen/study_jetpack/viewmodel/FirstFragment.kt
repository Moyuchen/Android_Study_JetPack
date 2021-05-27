package com.moyuchen.study_jetpack.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moyuchen.study_jetpack.R
import kotlinx.android.synthetic.main.fragment_first.*

/**
 *@Author zhangyabo
 *@Date  2021/5/27
 *@Des
 **/
class FirstFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first,null ,false)
    }

    override fun onResume() {
        super.onResume()

        val mViewModel = ViewModelProvider(
            activity!!,
            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        ).get(MyViewModel::class.java)

        mViewModel.progress?.observe(activity!!,object :Observer<Int>{
            override fun onChanged(t: Int?) {
//                TODO("Not yet implemented")
                seekBar.progress = t?:0
            }

        })

        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                TODO("Not yet implemented")
                mViewModel?.progress?.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                TODO("Not yet implemented")
            }

        })
    }
}