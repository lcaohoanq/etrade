package com.lcaohoanq.etrade.domain.token

interface ITokenCleanupService {
    fun cleanupExpiredTokens()
}