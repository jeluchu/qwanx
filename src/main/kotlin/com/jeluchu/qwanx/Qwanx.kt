package com.jeluchu.qwanx

import com.google.gson.GsonBuilder
import com.jeluchu.qwanx.core.connection.RestClient
import com.jeluchu.qwanx.models.images.ImageQueryEntity
import com.jeluchu.qwanx.core.utils.deserialize

object Qwanx {
    private var restClient = RestClient()
    private val gson = GsonBuilder().create()

    suspend fun getSearchImages(
        query: String,
        limit: Int = 50,
        locale: String = "es_ES"
    ): ImageQueryEntity {
        val endpoint = "search/images?t=images&q=$query"
        val params = mutableListOf<String>()

        params.add("count=$limit")
        params.add("locale=$locale")

        return gson.deserialize(
            restClient.request("$endpoint?${params.joinToString("&")}"),
            ImageQueryEntity::class.java
        )
    }
}