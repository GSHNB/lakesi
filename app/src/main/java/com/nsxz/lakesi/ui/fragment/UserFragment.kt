package com.nsxz.lakesi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.nsxz.lakesi.adapter.UserAdapter
import com.nsxz.lakesi.databinding.FragmentUserBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.util.clickNoRepeat
import com.nsxz.lakesi.vm.UserViewModel
import kotlinx.coroutines.flow.collect

/**
 * flow与room
 */
class UserFragment : BaseFragment<FragmentUserBinding,UserViewModel>() {



    override fun init() {
        mBinding.apply {
            btnSubmit.clickNoRepeat {
                val uid=etUserID.text.toString()
                val firstName=etName.text.toString()
                val lastName=etLastName.text.toString()
                mViewModel.insert(uid,firstName,lastName)
            }
        }
        val adapter=UserAdapter()
        mBinding.rvList.adapter=adapter

        lifecycleScope.launchWhenCreated {
            mViewModel.getAll().collect {
                adapter.setData(it)
            }
        }
    }

}