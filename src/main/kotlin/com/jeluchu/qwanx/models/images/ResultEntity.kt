package com.jeluchu.qwanx.models.images

import com.google.gson.annotations.SerializedName

data class ResultEntity(
    @SerializedName("filters")
    val filters: FiltersEntity?,

    @SerializedName("items")
    val items: List<ItemEntity>?,

    @SerializedName("lastPage")
    val lastPage: Boolean?,

    @SerializedName("total")
    val total: Int?
) {
    data class ItemEntity(

        @SerializedName("_id")
        val id: String?,

        @SerializedName("height")
        val height: Int?,

        @SerializedName("media")
        val media: String?,

        @SerializedName("media_fullsize")
        val fullSize: String?,

        @SerializedName("media_preview")
        val preview: String?,

        @SerializedName("size")
        val size: String?,

        @SerializedName("thumb_height")
        val thumbHeight: Int?,

        @SerializedName("thumb_type")
        val thumbType: String?,

        @SerializedName("thumb_width")
        val thumbWidth: Int?,

        @SerializedName("thumbnail")
        val thumbnail: String?,

        @SerializedName("title")
        val title: String?,

        @SerializedName("url")
        val url: String?,

        @SerializedName("width")
        val width: Int?
    )
}