package com.clovis.dataprovider.data.network.interfaces

interface HttpResponseListener : HttpParentListener {
    fun getStringResponse(response: String)
}