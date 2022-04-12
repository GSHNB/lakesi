package com.nsxz.lakesi.download

import java.io.File

sealed class DownloadStatus{

    object None:DownloadStatus()

    data class Progess(val value:Int):DownloadStatus()

    data class Error(val throwable: Throwable):DownloadStatus()

    data class Done(val file:File):DownloadStatus()



}