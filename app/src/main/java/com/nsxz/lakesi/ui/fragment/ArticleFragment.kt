package com.nsxz.lakesi.ui.fragment

import androidx.lifecycle.lifecycleScope
import com.nsxz.lakesi.adapter.ArticleAdapter
import com.nsxz.lakesi.databinding.FragmentArticleBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.util.watchTextChanged
import com.nsxz.lakesi.vm.ArticleViewModel

/**
 * Flow与Retrofit
 */
class ArticleFragment : BaseFragment<FragmentArticleBinding,ArticleViewModel>() {

    override fun init() {
        val adapter=ArticleAdapter()
        mBinding.rvList.adapter=adapter

        mBinding.etKey.watchTextChanged(lifecycleScope){
            mViewModel.searchArticles(it)
        }

        mViewModel.articles.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }




}