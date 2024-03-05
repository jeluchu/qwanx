package com.jeluchu.qwanx.models.images

import com.google.gson.annotations.SerializedName

data class FiltersEntity(
    @SerializedName("color")
    val color: FilterEntity?,

    @SerializedName("freshness")
    val freshness: FilterEntity?,

    @SerializedName("imagetype")
    val imagetype: FilterEntity?,

    @SerializedName("license")
    val license: FilterEntity?,

    @SerializedName("size")
    val size: FilterEntity?
) {
    data class FilterEntity(
        @SerializedName("label")
        val label: String?,

        @SerializedName("name")
        val name: String?,

        @SerializedName("selected")
        val selected: String?,

        @SerializedName("type")
        val type: String?,

        @SerializedName("values")
        val values: List<ValueEntity>?
    )

    data class ValueEntity(
        @SerializedName("label")
        val label: String?,

        @SerializedName("translate")
        val translate: Boolean?,

        @SerializedName("value")
        val value: String?
    )
}