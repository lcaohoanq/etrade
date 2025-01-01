package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.domain.user.User
import java.util.*

interface IAuthService {

    @Throws(Exception::class)
    fun register(accountRegisterDTO: AuthPort.AccountRegisterDTO): User

    @Throws(Exception::class)
    fun login(userLoginDTO: AuthPort.UserLoginDTO): Boolean

    @Throws(Exception::class)
    fun getUserDetailsFromToken(token: String): User

    @Throws(Exception::class)
    fun logout(token: String, user: User)

    @Throws(Exception::class)
    fun verifyOtpToVerifyUser(userId: UUID, otp: String)

    @Throws(Exception::class)
    fun verifyOtpIsCorrect(userId: UUID, otp: String)

}