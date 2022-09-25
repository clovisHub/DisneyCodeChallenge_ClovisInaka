package com.clovis.dataprovider.data.repo

import com.clovis.dataprovider.data.network.HttpRequestAsyncTask
import com.clovis.dataprovider.data.network.HttpRequestWithCoroutines
import com.clovis.dataprovider.data.network.interfaces.HttpErrorListener
import com.clovis.dataprovider.data.network.interfaces.HttpPopulationListener
import com.clovis.dataprovider.data.network.interfaces.HttpResponseListener

class Repository : HttpErrorListener, HttpResponseListener {

    companion object {
        var currentPopulationData: String = ""
    }

    fun refreshHttpRequest(url: String, data: String) {
        currentPopulationData = ""
        makeHttpRequest(url, data)
    }

    suspend fun makeCoroutineHttpRequest(url: String): String {
        return if (currentPopulationData.isEmpty()) {
            val response = HttpRequestWithCoroutines.request(url, this)
            //Save response if needed in room or preference if there is a need to reuse data
            //before returning it

            response
        } else ""
    }

    fun makeHttpRequest(url: String, data: String) {
        if (currentPopulationData.isEmpty()) HttpRequestAsyncTask().execute(url)
    }

    fun getResponse(): String {
        val response = HttpPopulationListener.getHttpResponse().ifEmpty { currentPopulationData }
        if (HttpPopulationListener.getHttpResponse().isNotEmpty()) savePopulationData(response)

        return response
    }


    private fun savePopulationData(data: String) {

    }

    override fun getErrorCode(errorCode: Int) {
        TODO("Not yet implemented")
    }

    override fun getErrorMessage(errorMessage: String) {
        if (errorMessage.isNotEmpty()) {
            currentPopulationData = ""
        }
    }

    override fun getStringResponse(response: String) {
        currentPopulationData = response
        val response = HttpPopulationListener.getHttpResponse().ifEmpty { currentPopulationData }
        //Save response if needed in room or preference if there is a need to reuse data.
        if (HttpPopulationListener.getHttpResponse().isNotEmpty()) savePopulationData(response)
    }

}