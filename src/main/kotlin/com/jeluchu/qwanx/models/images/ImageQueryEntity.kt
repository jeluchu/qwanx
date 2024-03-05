package com.jeluchu.qwanx.models.images

import com.google.gson.annotations.SerializedName

data class ImageQueryEntity(
    @SerializedName("data")
    val data: Data,

    @SerializedName("status")
    val status: String
) {
    data class Data(
        @SerializedName("query")
        val query: QueryEntity,

        @SerializedName("result")
        val result: ResultEntity
    )
}