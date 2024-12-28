package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.exception.MethodArgumentNotValidException
import jakarta.validation.Valid
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AuthController(
    private val authService: IAuthService
) {

    private val logger = KotlinLogging.logger {}

    @PostMapping("/auth/login")
    fun login(
        @Valid @ModelAttribute login: AuthPort.UserLoginDTO
    ): String {
        authService.login(login).let {
            logger.info { "Login success" }
            return "redirect:/" // redirect to home page
        }
    }

    @PostMapping("/auth/register")
    fun register(
        @Valid @ModelAttribute register: AuthPort.AccountRegisterDTO,
        result: BindingResult
    ): String {
        if (result.hasErrors()) {
            throw MethodArgumentNotValidException(result)
        }

        authService.register(register)
        logger.info { "Register success" }
        return "redirect:/sign-in"
    }

}