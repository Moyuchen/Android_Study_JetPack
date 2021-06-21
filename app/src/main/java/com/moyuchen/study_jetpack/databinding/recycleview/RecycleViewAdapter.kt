package com.moyuchen.study_jetpack.databinding.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.moyuchen.study_jetpack.BR
import com.moyuchen.study_jetpack.R
import com.moyuchen.study_jetpack.databinding.ItemTestBinding
import java.util.ArrayList

/**
 *@Author zhangyabo
 *@Date  2021/6/14
 *@Des
 **/
class RecycleViewAdapter(var datas: List<TestEntity>): RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>() {
//    var datas = listOf<TestEntity>()
//    init {
//        datas = data
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
//        TODO("Not yet implemented")
        val itemBingding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_test,
            parent,
            false
        ) as ItemTestBinding


        return RecycleViewHolder(itemBingding)
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return datas?.let {
            it.size
        }
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
//        TODO("Not yet implemented")
        holder.itemTestBinding?.let {
//            it = datas[position]
            it.entity = datas[position]
            it.executePendingBindings()
        }


    }


    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTestBinding:ItemTestBinding? = null
        constructor(itemView: ItemTestBinding) : this(itemView.root){
            itemTestBinding = itemView
        }


    }
}