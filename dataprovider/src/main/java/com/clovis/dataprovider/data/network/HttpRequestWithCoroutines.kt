package com.clovis.dataprovider.data.network

import com.clovis.dataprovider.data.network.interfaces.HttpErrorListener
import com.clovis.dataprovider.data.network.interfaces.HttpParentListener
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.resumeWithException

class HttpRequestWithCoroutines {

    companion object {

        suspend fun request(link: String, listener: HttpParentListener): String {
            return suspendCancellableCoroutine { continuation ->
                try {
                    val reader: BufferedReader
                    val url = URL(link)

                    with(url.openConnection() as HttpURLConnection) {
                        requestMethod = "GET"
                        reader = BufferedReader(InputStreamReader(inputStream) as Reader?)

                        val response = StringBuffer()
                        var inputLine = reader.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = reader.readLine()
                        }
                        reader.close()

                        if (continuation.isActive) {
                            continuation.resume(response.toString()) {
                                when (listener) {
                                    is HttpErrorListener -> listener.getErrorMessage(it.cause.toString())
                                }
                            }
                        }
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                    if (continuation.isActive) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        }
    }
}
