package com.clovis.dataprovider.data.network.interfaces

interface HttpErrorListener : HttpParentListener {
    fun getErrorCode(errorCode: Int)
    fun getErrorMessage(errorMessage: String)
}