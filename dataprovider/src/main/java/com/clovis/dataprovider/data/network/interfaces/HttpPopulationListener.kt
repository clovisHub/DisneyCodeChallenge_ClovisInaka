package com.clovis.dataprovider.data.network.interfaces


object HttpPopulationListener {

    private var errorCode: Int = 0
    private var errorString: String = ""
    private var response: String = ""

    fun setHttpResponse(responseMessage: String) {
        response = responseMessage
    }

    fun getHttpResponse(): String {
        return response
    }

    fun setHttpError(responseCode: Int) {
        errorCode = responseCode
    }

    fun setHttpErrorMessage(responseCode: String) {
        errorString = responseCode
    }

    /**
     * Return zero if there is not error code
     */
    fun getHttpError(): Int {
        return errorCode.takeIf { errorString.isEmpty() } ?: 0
    }

}


