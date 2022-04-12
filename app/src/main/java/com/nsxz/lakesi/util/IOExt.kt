package com.nsxz.lakesi.util

import com.nsxz.lakesi.download.DownloadStatus
import java.io.InputStream
import java.io.OutputStream

inline fun InputStream.copyTo(out:OutputStream,bufferSize:Int=1024,progess:(Long)->Unit){
    var bytesCopied:Long=0
    val buffer=ByteArray(bufferSize)
    var bytes=read(buffer)
    while (bytes>=0){
        out.write(buffer,0,bytes)
        bytesCopied+=bytes
        bytes=read(buffer)
        progess(bytesCopied)
    }
}