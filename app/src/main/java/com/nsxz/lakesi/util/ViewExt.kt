package com.nsxz.lakesi.util

import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

var previousClickTime = 0L
fun View.clickNoRepeat(listener: () -> Unit) {
    setOnClickListener {
        val clickTime = SystemClock.uptimeMillis()
        if (clickTime - previousClickTime > 100) {
            listener.invoke()
        }
        previousClickTime = clickTime
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun TextView.textWatcherFlow() = callbackFlow {
    val textWatcher = addTextChangedListener { trySend(it.toString()) }
    awaitClose { removeTextChangedListener(textWatcher) }
}

fun TextView.watchTextChanged(scope:LifecycleCoroutineScope,onChanged:(String)->Unit){
    scope.launchWhenCreated {
        this@watchTextChanged.textWatcherFlow().collect(onChanged)
    }
}