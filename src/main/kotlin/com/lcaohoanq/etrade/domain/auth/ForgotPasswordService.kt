package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.constant.EmailSubject
import com.lcaohoanq.etrade.domain.mail.IMailService
import com.lcaohoanq.etrade.domain.otp.IOtpService
import com.lcaohoanq.etrade.domain.otp.Otp
import com.lcaohoanq.etrade.domain.user.User
import com.lcaohoanq.etrade.enums.EmailCategoriesEnum
import com.lcaohoanq.etrade.util.OtpUtil
import jakarta.mail.MessagingException
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.thymeleaf.context.Context
import java.time.LocalDateTime

@Slf4j
@Service
open class ForgotPasswordService(
    private val mailService: IMailService,
    private val otpService: IOtpService
) : IForgotPasswordService {
    
    @Transactional
    @Throws(MessagingException::class)
    override fun sendEmailOtp(existingUser: User) {
        val context = Context()
        val otp = otpService.generateOtp()
        context.setVariable("name", existingUser.name)
        context.setVariable("otp", otp)

        mailService.sendMail(
            existingUser.email,
            EmailSubject.subjectForgotPassword(existingUser.name),
            EmailCategoriesEnum.FORGOT_PASSWORD.type,
            context
        )

        val otpEntity = Otp()
        otpEntity.otp = otp
        otpEntity.email = existingUser.email
        otpEntity.expiredAt = LocalDateTime.now().plusMinutes(5)
        otpEntity.isUsed = false
        otpEntity.isExpired = false

        otpService.createOtp(otpEntity)
    }
}
