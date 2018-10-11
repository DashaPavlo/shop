package com.example.pavlovadasha.dashapavlovashop

import okhttp3.OkHttpClient
import okhttp3.Request

interface RequestMaker {
    fun make(url: String): String
}

class OkHttpRequestMaker : RequestMaker {


    val client = OkHttpClient()

    override fun make(url: String) = run {

        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request)
                .execute()

        response.body()!!.string()
    }

}


