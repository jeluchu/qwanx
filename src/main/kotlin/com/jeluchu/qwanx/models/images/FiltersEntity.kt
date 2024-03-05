package com.jeluchu.qwanx.models.images

data class FiltersEntity(
    val color: FilterEntity,
    val freshness: FilterEntity,
    val imagetype: FilterEntity,
    val license: FilterEntity,
    val size: FilterEntity
) {
    data class FilterEntity(
        val label: String,
        val name: String,
        val selected: String,
        val type: String,
        val values: List<ValueEntity>
    )

    data class ValueEntity(
        val label: String,
        val translate: Boolean,
        val value: String
    )
}