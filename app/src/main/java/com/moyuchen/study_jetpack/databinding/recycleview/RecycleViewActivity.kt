package com.moyuchen.study_jetpack.databinding.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.moyuchen.study_jetpack.R
import com.moyuchen.study_jetpack.databinding.ActivityRecycleViewBinding
import kotlinx.android.synthetic.main.activity_recycle_view.view.*

class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycle_view)
        val recycleViewBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_recycle_view
        ) as ActivityRecycleViewBinding
        recycleViewBinding.recycle.layoutManager = LinearLayoutManager(this)

        recycleViewBinding.recycle.adapter = RecycleViewAdapter(getData())

    }

    private fun getData(): List<TestEntity> {
        var data = mutableListOf<TestEntity>()
        var entity:TestEntity? = null
        for (index in 1..10){
            entity = TestEntity()
            entity.name ="zhangsan${index}"
            entity.age = index
            entity.img = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201107%2F23%2F20110723200245_2HU4e.thumb.700_0.jpg&refer=http%3A%2F%2Fcdn.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1625323582&t=b468c5ff7bea4bf5c7f5ec29cfb2399b"
            data.add(entity)

        }
        return data;
    }
}