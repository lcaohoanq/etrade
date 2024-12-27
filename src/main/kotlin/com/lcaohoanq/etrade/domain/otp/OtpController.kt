package com.lcaohoanq.etrade.domain.otp

import com.lcaohoanq.etrade.api.ApiResponse
import com.lcaohoanq.etrade.domain.localization.LocalizationUtils
import com.lcaohoanq.etrade.api.ApiConstant
import com.lcaohoanq.etrade.domain.localization.MessageKey
import com.lcaohoanq.etrade.domain.auth.AuthPort.VerifyUserDTO
import com.lcaohoanq.etrade.domain.auth.AuthService
import com.lcaohoanq.etrade.domain.auth.OtpResponse
import com.lcaohoanq.etrade.domain.mail.MailController
import com.lcaohoanq.etrade.domain.user.IUserService
import com.lcaohoanq.etrade.exception.MethodArgumentNotValidException
import jakarta.mail.MessagingException
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("${ApiConstant.API_PREFIX}/otp")
class OtpController(
    private val mailController: MailController,
    private val userService: IUserService,
    private val localizationUtils: LocalizationUtils,
    private val authService: AuthService
) {

    @GetMapping("/send")
    @Throws(MessagingException::class)
    fun sendOtp(@RequestParam type: String, @RequestParam recipient: String): ResponseEntity<*> {
        return when (type.lowercase(Locale.getDefault())) {
            "mail" -> mailController.sendOtp(recipient)
            else -> ResponseEntity("Invalid type specified", HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/verify")
    @Throws(Exception::class)
    fun verifiedUserNotLogin(
        @RequestBody verifyUserDTO: @Valid VerifyUserDTO,
        result: BindingResult
    ): ResponseEntity<ApiResponse<OtpResponse>> {
        if (result.hasErrors()) {
            throw MethodArgumentNotValidException(result)
        }
        val user = userService.findUserByEmail(verifyUserDTO.email)
        authService.verifyOtpIsCorrect(user.id, verifyUserDTO.otp)
        return ResponseEntity.ok().body(
            ApiResponse.builder<OtpResponse>()
                .message(localizationUtils.getLocalizedMessage(MessageKey.OTP_IS_CORRECT))
                .isSuccess(true)
                .statusCode(HttpStatus.OK.value())
                .build()
        )
    }
}

