package com.nsxz.lakesi.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.nsxz.lakesi.databinding.FragmentTextBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.util.collectInCoroutine
import com.nsxz.lakesi.vm.BaseViewModel
import com.nsxz.lakesi.vm.SharedFlowViewModel
import kotlinx.coroutines.flow.collect


class TextFragment : BaseFragment<FragmentTextBinding,BaseViewModel>() {

    private val vm by viewModels<SharedFlowViewModel>({parentFragment as ViewModelStoreOwner})

    override fun init() {
        vm.time.collectInCoroutine(lifecycleScope){
            mBinding.tvCode.text=it
        }


    }

}