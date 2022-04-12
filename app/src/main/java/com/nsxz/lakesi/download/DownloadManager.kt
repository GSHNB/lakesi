package com.nsxz.lakesi.download

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import com.nsxz.lakesi.util.copyTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import java.io.IOException

object DownloadManager {

    fun down(url:String,file:File):Flow<DownloadStatus>{

        return flow {
            val request=Request.Builder().url(url).get().build()
            val response=OkHttpClient.Builder().build().newCall(request).execute()
            if (response.isSuccessful){
                response.body?.let { body->
                   val total= body.contentLength()
                    var emittedProgress=0L
                    file.outputStream().use { output->
                        val input=body.byteStream()
                        input.copyTo(output){bytesCopied->
                            val progress=bytesCopied*100/total
                            if (progress-emittedProgress>5){
                                kotlinx.coroutines.delay(100)
                                emit(DownloadStatus.Progess(progress.toInt()))
                                emittedProgress=progress
                            }
                        }
                    }
                }

                emit(DownloadStatus.Done(file))
            }else{
                throw IOException(response.toString())
            }
        }.catch {
            file.delete()
            emit(DownloadStatus.Error(it))
        }.flowOn(Dispatchers.IO)
    }

}