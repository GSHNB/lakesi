package com.nsxz.lakesi.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.nsxz.lakesi.R
import com.nsxz.lakesi.databinding.FragmentDownloadBinding
import com.nsxz.lakesi.databinding.FragmentHomeBinding
import com.nsxz.lakesi.download.DownloadManager
import com.nsxz.lakesi.download.DownloadStatus
import com.nsxz.lakesi.ui.base.BaseFragment
import com.nsxz.lakesi.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import java.io.File


/**
 * flow 实现下载
 */
class DownloadFragment : BaseFragment<FragmentDownloadBinding,BaseViewModel>() {


    val url="https://image.baidu.com/search/index?ct=201326592&z=0&tn=baiduimage&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1305456094,3865830840&os=3330783663,95601121&simid=3417198601,116276182&pn=1&di=7060663421280190465&ln=1566&fr=&fmq=1648654861255_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&oriquery=%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fimg.jj20.com%252Fup%252Fallimg%252Ftp09%252F210611094Q512b-0-lp.jpg%26refer%3Dhttp%253A%252F%252Fimg.jj20.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Dauto%3Fsec%3D1651246850%26t%3Daaaca29060a6b9ef0e2d9eb74c2431d0&rpstart=0&rpnum=0&adpicid=0&nojc=undefined&tt=1&dyTabStr=MCwzLDYsMiwxLDQsNSw3LDgsOQ%3D%3D"
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity.lifecycle.addObserver(object :LifecycleObserver{

            @SuppressLint("SetTextI18n")
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate(){

                lifecycleScope.launchWhenCreated{
                    context.apply {
                        val file= File(getExternalFilesDir(null)?.path,"pic.JPG")
                        DownloadManager.down(url, file).collect {
                            when (it) {
                                is DownloadStatus.Progess -> {
                                    mBinding.progressBar.progress=it.value
                                    mBinding.tvRadius.text="${it.value}%"
                                }

                                is DownloadStatus.Error->{
                                    Toast.makeText(this,"下載失敗",Toast.LENGTH_SHORT).show()
                                }

                                is DownloadStatus.Done->{
                                    mBinding.progressBar.progress=100
                                    mBinding.tvRadius.text="100%"
                                    Toast.makeText(this, "下載完成", Toast.LENGTH_SHORT).show()
                                }
                                else -> {}
                            }
                        }
                    }
                }
            }
        })
    }



    override fun init() {

    }


}