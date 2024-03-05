package com.jeluchu.qwanx.models.images

import com.google.gson.annotations.SerializedName

data class QueryEntity(
    @SerializedName("locale")
    val locale: String?,

    @SerializedName("offset")
    val offset: Int?,

    @SerializedName("query")
    val query: String?,

    @SerializedName("queryContext")
    val queryContext: QueryContext?
) {
    data class QueryContext(
        @SerializedName("originalQuery")
        val originalQuery: String?
    )
}