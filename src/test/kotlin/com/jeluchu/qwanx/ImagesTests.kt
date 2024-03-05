package com.jeluchu.qwanx

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ImagesTests {
    @Test
    fun `on getSearchImages pass a query and return images data`() {
        val query = "Steins;Gate"
        val result = runBlocking { Qwanx.getSearchImages(query) }
        assertTrue(result.data.result.items.isNotEmpty())
        runBlocking { delay(3000) }
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Qwanx
        }
    }
}