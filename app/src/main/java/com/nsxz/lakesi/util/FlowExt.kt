package com.nsxz.lakesi.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectInCoroutine(scope:CoroutineScope,collector: FlowCollector<T>){
    scope.launch {
        this@collectInCoroutine.collect(collector)
    }
}