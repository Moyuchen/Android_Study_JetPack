package com.moyuchen.study_jetpack.databinding

import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.moyuchen.study_jetpack.BR

/**
 *@Author zhangyabo
 *@Date  2021/6/6
 *@Des
 **/
class BaseObservableMedel : BaseObservable {
    var entity: DataBindingEntity? = null

    constructor() {
        entity = DataBindingEntity("Moyuchen")
    }

    @Bindable
    fun getName(): String {
        Log.i("BaseObservableMedel", "getName: ${entity!!.name}}")
        return entity!!.name
    }

    fun setName(name: String) {
        if (!name.isNullOrEmpty() && !name.equals(entity?.name)) {
            entity?.name = name
            notifyPropertyChanged(BR.name)

        }

    }


}