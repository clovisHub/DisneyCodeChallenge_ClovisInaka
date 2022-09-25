package com.clovis.dataprovider.data.network

import android.os.AsyncTask
import com.clovis.dataprovider.data.network.interfaces.HttpPopulationListener
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL


class HttpRequestAsyncTask : AsyncTask<String?, Int?, String?>() {

    override fun doInBackground(vararg params: String?): String? {
        val link = params[0]

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

                HttpPopulationListener.setHttpResponse(response.toString())

            }

        } catch (e: Exception) {
            HttpPopulationListener.setHttpErrorMessage(e.message.toString())
        }

        return null
    }
}