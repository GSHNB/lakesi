package com.nsxz.lakesi.vm

import android.app.Application
import android.os.SystemClock
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SharedFlowViewModel(app:Application): BaseViewModel(app) {

    val time= MutableSharedFlow<String>()
    private lateinit var job:Job
    fun startEmit(){
        job=viewModelScope.launch(Dispatchers.Default) {
            while (true){
                delay(17)
                time.emit(SystemClock.uptimeMillis().toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) {
            job.cancel()
        }
    }

}