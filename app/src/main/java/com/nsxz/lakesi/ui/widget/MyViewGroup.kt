package com.nsxz.lakesi.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import com.nsxz.lakesi.LOG_TAG
import com.nsxz.lakesi.gerEvenName

class MyViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        val result=super.dispatchTouchEvent(ev)

        val evName=gerEvenName(ev)

        Log.d(LOG_TAG, "dispatchTouchEvent: $result,$evName")

        return result
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val result=super.onInterceptTouchEvent(ev)

        Log.d(LOG_TAG, "onInterceptTouchEvent: $result")

        return result
    }


}