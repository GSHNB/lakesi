package com.nsxz.lakesi.ui.base

import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.nsxz.lakesi.vm.BaseViewModel
import kotlin.reflect.KClass

interface IViewModelCreator<VM:BaseViewModel> {
    fun createViewModel(): Lazy<VM>

    fun getViewModelFactory(): ViewModelProvider.Factory
}