package com.jeluchu.qwanx.core.connection

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.jeluchu.qwanx.core.client.QwanxClient
import com.jeluchu.qwanx.core.exception.QwanxException
import com.jeluchu.qwanx.core.utils.Log
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.headers

/**
 * Class that handle request.
 * @param isDebug: a boolean that indicate if you run it on debug or not. If yes, it'll throw exception if something happen.
 * @param url: Custom URL, will use default (Qwanx URL) if null or empty.
 */
class RestClient(private val isDebug: Boolean = false, private val url: String? = null) : QwanxClient() {
    private val gson = Gson()
    private val client = httpClient
    private val usedURL = if (url.isNullOrEmpty()) BASE_URL else url

    suspend fun request(endPoint: String, data: JsonObject? = null): JsonElement {
        runCatching {
            var url = usedURL + endPoint
            if (data != null) {
                url += "?" + data.entrySet().joinToString("&") { entry ->
                    "${entry.key}=${entry.value}"
                }
            }

            val response = client.get(url) {
                headers {
                    append(HttpHeaders.Accept, "application/json")
                }
            }

            val body = response.body<JsonElement>()
            val contentType = response.headers["Content-Type"]
            val json = if (contentType?.contains("application/json", true) == true) {
                gson.fromJson(body, JsonElement::class.java)
            } else null

            if (response.status.value !in 200..299) {
                if (response.status.value in 500..599) {
                    val ex = Exception("An internal server error has occurred, code: ${response.status.value}")
                    if (isDebug) throw ex else exceptionHandler(ex)
                } else {
                    val ex = QwanxException(
                        "Qwanx API returns code ${response.status.value} and body ${json?.toString()}",
                        response.status.value
                    )

                    if (isDebug) throw ex
                    else exceptionHandler(ex)
                }
            }

            return json ?: JsonObject()
        }.getOrElse { throwable -> throw throwable }
    }

    private fun exceptionHandler(ex: Exception, message: String? = null) : JsonObject {
        if (message.isNullOrEmpty()) Log.error("Something went wrong! Exception: ${ex.localizedMessage}")
        else Log.error(ex, "Something went wrong! Exception: ${ex.localizedMessage}")
        return JsonObject()
    }

    companion object {
        const val BASE_URL = "https://api.qwant.com/v3/"
    }
}