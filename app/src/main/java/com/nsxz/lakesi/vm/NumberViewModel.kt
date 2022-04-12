package com.nsxz.lakesi.vm

import android.app.Application
import kotlinx.coroutines.flow.MutableStateFlow

class NumberViewModel(app:Application): BaseViewModel(app) {
    val number= MutableStateFlow(0)

    fun increment(){
        number.value++
    }

    fun decrement(){
        number.value--
    }
}