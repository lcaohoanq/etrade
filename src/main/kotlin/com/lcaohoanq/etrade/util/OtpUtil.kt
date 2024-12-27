package com.lcaohoanq.etrade.util

object OtpUtil {
    fun generateOtp(): String {
        return ((Math.random() * 9000).toInt() + 1000).toString()
    }
}
