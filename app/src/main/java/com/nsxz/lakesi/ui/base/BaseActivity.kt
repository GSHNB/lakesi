package com.nsxz.lakesi.ui.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.nsxz.lakesi.util.initViewBinding
import com.nsxz.lakesi.vm.BaseViewModel
import com.nsxz.lakesi.vm.UserViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<VB:ViewBinding,VM:BaseViewModel>: AppCompatActivity(),IViewModelCreator<VM>,IInitAction {

    protected val mBinding by lazy { initViewBinding() }

    protected val mViewModel by createViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        init()
        initClick()
        observeData()

    }

    override fun createViewModel(): Lazy<VM> {
        val kc1 = this::class.supertypes.first().arguments[1].type?.classifier
        return ViewModelLazy(kc1 as KClass<VM>, { this.viewModelStore }, ::getViewModelFactory)
    }

    override fun getViewModelFactory(): ViewModelProvider.Factory{
        return defaultViewModelProviderFactory
    }

}