package com.jeluchu.qwanx.models.images

data class QueryEntity(
    val locale: String,
    val offset: Int,
    val query: String,
    val queryContext: QueryContext
) {
    data class QueryContext(
        val originalQuery: String
    )
}