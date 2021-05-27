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
import kotlinx.android.synthetic.main.fragment_second.*

/**
 *@Author zhangyabo
 *@Date  2021/5/27
 *@Des
 **/
class SecondFragment  : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,null,false)
    }

    override fun onResume() {
        super.onResume()

        val mViewModel = ViewModelProvider(
            activity!!,
            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        )
            .get(MyViewModel::class.java)

        mViewModel.progress?.observe(activity!!, Observer {
            seekBar2.progress = it
        })

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                TODO("Not yet implemented")

                mViewModel.progress?.value = progress
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