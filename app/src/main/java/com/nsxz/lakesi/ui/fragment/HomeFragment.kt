package com.nsxz.lakesi.ui.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nsxz.lakesi.R
import com.nsxz.lakesi.databinding.FragmentHomeBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.util.clickNoRepeat
import com.nsxz.lakesi.vm.BaseViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>() {


    override fun init() {
        mBinding.apply {

            btnDownload.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_downloadFragment)
            }

            btnRoom.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_userFragment)
            }

            btnRetrofit.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_articleFragment)
            }

            btnStateflow.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_numberFragment)
            }

            btnSharedFlow.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_sharedFlowFragment)
            }

            btnPaging3.clickNoRepeat {
                findNavController().navigate(R.id.action_homeFragment_to_pagingFragment)
            }

        }
    }




}