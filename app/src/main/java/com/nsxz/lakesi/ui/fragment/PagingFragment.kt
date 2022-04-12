package com.nsxz.lakesi.ui.fragment

import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.nsxz.lakesi.adapter.ArticlePagingAdapter
import com.nsxz.lakesi.adapter.LoadMoreAdapter
import com.nsxz.lakesi.databinding.FragmentPagingBinding
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.vm.ArticlePageViewModel
import com.nsxz.lakesi.vm.BaseViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 * flow与paging3
 */
class PagingFragment:BaseFragment<FragmentPagingBinding,ArticlePageViewModel>() {



    override fun init() {
        val adapter=ArticlePagingAdapter()
        mBinding.apply {
            rvList.adapter=adapter.withLoadStateFooter(LoadMoreAdapter())
            swipeRefreshLayout.setOnRefreshListener {
                adapter.refresh()
            }
        }

        lifecycleScope.launchWhenCreated {
            mViewModel.loadArticle().collectLatest {
                adapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest { state->
                mBinding.swipeRefreshLayout.isRefreshing=state.refresh is LoadState.Loading

            }
        }


    }
}