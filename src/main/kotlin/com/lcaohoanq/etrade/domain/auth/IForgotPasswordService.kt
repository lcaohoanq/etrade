package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.domain.user.User
import jakarta.mail.MessagingException

interface IForgotPasswordService {
    @Throws(MessagingException::class)
    fun sendEmailOtp(existingUser: User)
}
