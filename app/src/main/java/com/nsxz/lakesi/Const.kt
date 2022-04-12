package com.nsxz.lakesi

import android.view.MotionEvent

const val LOG_TAG="MyTestLog"

fun gerEvenName(ev:MotionEvent?):String{
    return when(ev?.action){
        MotionEvent.ACTION_DOWN-> "down"

        MotionEvent.ACTION_MOVE->"move"

        MotionEvent.ACTION_UP->"up"

        else -> ""
    }

}
