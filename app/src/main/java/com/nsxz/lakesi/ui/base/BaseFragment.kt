package com.nsxz.lakesi.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import com.nsxz.lakesi.LOG_TAG
import com.nsxz.lakesi.util.initViewBinding
import com.nsxz.lakesi.vm.BaseViewModel
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST", "DEPRECATION")
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment(),IViewModelCreator<VM>,IInitAction {

    protected val mBinding by lazy { initViewBinding() }
    protected val mViewModel by createViewModel()
    //mRootView是否已经完成创建
    private var isViewCreated = false
    //当前fragment可见状态
    private var currentVisibleState: Boolean = false
    private var mRootView: View? = null
    protected lateinit var mActivity : AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity=context as AppCompatActivity
//        requireActivity().lifecycle.addObserver(object : LifecycleObserver {
//
//            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//            fun onCreated() {
//            }
//
//        })

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (mRootView == null) {
            mRootView = mBinding.root
        }
        isViewCreated = true
        if (userVisibleHint) {
            dispatchUserVisibleHint(true)
        }

        return mRootView!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initClick()
        observeData()

    }

    override fun onResume() {
        super.onResume()
        if (currentVisibleState.not()&&userVisibleHint){
            dispatchUserVisibleHint(true)
        }

    }

    override fun onPause() {
        super.onPause()
        if (currentVisibleState&&userVisibleHint){
            dispatchUserVisibleHint(false)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreated = false
        mRootView = null
    }




    override fun createViewModel(): Lazy<VM> {
        val kc1 = this::class.supertypes.first().arguments[1].type?.classifier
        return ViewModelLazy(kc1 as KClass<VM>, { this.viewModelStore }, ::getViewModelFactory)
    }


    override fun getViewModelFactory(): ViewModelProvider.Factory {

        return defaultViewModelProviderFactory
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser==currentVisibleState) return

        currentVisibleState = isVisibleToUser
        if (isViewCreated) {
            if (currentVisibleState.not() && isVisibleToUser) {
                dispatchUserVisibleHint(true)
            } else if (currentVisibleState && isVisibleToUser.not()) {
                dispatchUserVisibleHint(false)
            }
        }
    }

    /**
     * 分发数据加载与停止加载事物
     */
    private fun dispatchUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            onLazyLoad()
        } else {
            onStopLoad()
        }
    }

    /**
     * 加载数据
     */
    open fun onLazyLoad() {}

    /**
     * 停止加载数据
     */
    open fun onStopLoad() {}
}