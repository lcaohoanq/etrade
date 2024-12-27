package com.lcaohoanq.etrade.exception

class UserHasBeenBannedException(private val email_phone: String) : RuntimeException(
    "Account $email_phone has been banned"
) {
    private val id: Long? = null
}