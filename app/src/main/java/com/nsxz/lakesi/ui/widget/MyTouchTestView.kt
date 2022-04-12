package com.nsxz.lakesi.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.nsxz.lakesi.LOG_TAG
import com.nsxz.lakesi.gerEvenName

class MyTouchTestView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        val result=super.dispatchTouchEvent(event)
        val evName= gerEvenName(event)
        Log.d(LOG_TAG, "childview dispatchTouchEvent: $result,action=$evName")
        return result
    }


}