package com.jeluchu.qwanx.core.exception

data class QwanxException(override val message: String?, val code: Int? = null) : Exception()