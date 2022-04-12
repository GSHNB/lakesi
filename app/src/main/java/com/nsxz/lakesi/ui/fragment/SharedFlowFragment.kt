package com.nsxz.lakesi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nsxz.lakesi.databinding.FragmentSharedFlowBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.vm.SharedFlowViewModel
import kotlin.reflect.KClass


class SharedFlowFragment : BaseFragment<FragmentSharedFlowBinding,SharedFlowViewModel>() {

    override fun init() {
        mViewModel.startEmit()
    }

}