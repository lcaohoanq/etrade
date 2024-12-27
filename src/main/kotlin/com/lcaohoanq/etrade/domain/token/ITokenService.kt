package com.lcaohoanq.etrade.domain.token

import com.lcaohoanq.etrade.base.exception.DataNotFoundException
import com.lcaohoanq.etrade.domain.user.User
import org.springframework.stereotype.Service
import java.util.*

@Service
interface ITokenService {
    fun addToken(userId: UUID, token: String, isMobileDevice: Boolean): Token

    @Throws(Exception::class)
    fun refreshToken(refreshToken: String, user: User): Token

    @Throws(DataNotFoundException::class)
    fun deleteToken(token: String, user: User)

    @Throws(DataNotFoundException::class)
    fun findUserByToken(token: String): Token
}
