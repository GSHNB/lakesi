package com.nsxz.lakesi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.nsxz.lakesi.R
import com.nsxz.lakesi.databinding.FragmentArticleBinding
import com.nsxz.lakesi.databinding.FragmentNumberBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.util.clickNoRepeat
import com.nsxz.lakesi.util.collectInCoroutine
import com.nsxz.lakesi.vm.NumberViewModel


/**
 * StateFlow
 */
class NumberFragment : BaseFragment<FragmentNumberBinding, NumberViewModel>() {
    override fun init() {

    }

    override fun initClick() {
        super.initClick()
        mBinding.apply {
            btnPlus.clickNoRepeat {
                mViewModel.increment()
            }

            btnSub.clickNoRepeat {
                mViewModel.decrement()
            }

            mViewModel.number.collectInCoroutine(lifecycleScope) {
                tvNumber.text = it.toString()
            }

        }
    }

}

