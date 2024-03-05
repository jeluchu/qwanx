package com.jeluchu.qwanx.models.images

data class ResultEntity(
    val filters: FiltersEntity,
    val items: List<ItemEntity>,
    val lastPage: Boolean,
    val total: Int
) {
    data class ItemEntity(
        val _id: String,
        val height: Int,
        val media: String,
        val media_fullsize: String,
        val media_preview: String,
        val size: String,
        val thumb_height: Int,
        val thumb_type: String,
        val thumb_width: Int,
        val thumbnail: String,
        val title: String,
        val url: String,
        val width: Int
    )
}