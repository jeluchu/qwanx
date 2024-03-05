package com.jeluchu.qwanx.models.images

data class ImageQueryEntity(
    val data: Data,
    val status: String
) {
    data class Data(
        val query: QueryEntity,
        val result: ResultEntity
    )
}