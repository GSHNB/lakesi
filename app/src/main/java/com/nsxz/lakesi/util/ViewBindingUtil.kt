package com.nsxz.lakesi.util

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.nsxz.lakesi.ui.base.BaseActivity
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.vm.BaseViewModel
import java.lang.reflect.ParameterizedType


/**
 *
 */
@Suppress("UNCHECKED_CAST")
private fun <VB> initViewBinding(clazz:Class<Any>, layoutInflater:LayoutInflater):VB?{
    val type=clazz.genericSuperclass
    if (type is ParameterizedType){
        val params=type.actualTypeArguments
        val vbClazz=params.firstOrNull()
        val method=(vbClazz as Class<VB>).getMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null,layoutInflater) as VB

    }
    return null
}

fun <VB:ViewBinding,VM:BaseViewModel> BaseActivity<VB,VM>.initViewBinding()=initViewBinding<VB>(javaClass,layoutInflater)!!

fun <VB:ViewBinding,VM:BaseViewModel> BaseFragment<VB,VM>.initViewBinding()=initViewBinding<VB>(javaClass,layoutInflater)!!