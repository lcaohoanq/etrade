package com.lcaohoanq.etrade.exception

class JwtAuthenticationException : RuntimeException {
    constructor(message: String?) : super(message)

    constructor(message: String?, cause: Throwable?) : super(message, cause)
}
