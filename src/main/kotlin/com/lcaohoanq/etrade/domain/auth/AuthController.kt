package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.exception.MethodArgumentNotValidException
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AuthController(
    private val authService: IAuthService
) {

    val validAccount = mutableListOf(
        AuthPort.UserLoginDTO("admin@gmail.com", "1"),
        AuthPort.UserLoginDTO("user@gmail.com", "1")
    )

    private val logger = KotlinLogging.logger {}

    @PostMapping("/auth/login")
    fun login(
        @ModelAttribute login: AuthPort.UserLoginDTO
    ): String {
        validAccount.find { it.email == login.email && it.password == login.password }?.let {
            logger.info { "Login success" }
            return "redirect:/" // redirect to home page
        }
        logger.error { "Login failed" }
        return "redirect:/sign-in"
    }

    @PostMapping("/auth/register")
    fun register(
        @ModelAttribute register: AuthPort.AccountRegisterDTO,
        result: BindingResult
    ): String {

        if (result.hasErrors()) {
            throw MethodArgumentNotValidException(result)
            logger.error { "Register failed" }
            return "redirect:/sign-up"
        }

        validAccount.add(
            AuthPort.UserLoginDTO(register.email, register.password)
        )
        logger.info { "Register success" }
        return "redirect:/sign-in"
    }

    @GetMapping("sign-in")
    fun signIn(model: Model): String {
        model.addAttribute("login", AuthPort.UserLoginDTO())
        return "sign-in"
    }

    @GetMapping("sign-up")
    fun signUp(model: Model): String {
        model.addAttribute("register", AuthPort.AccountRegisterDTO())
        return "sign-up"
    }

    @GetMapping("forgot-password")
    fun forgotPassword(): String {
        return "forgot-password"
    }

    @GetMapping("reset-password")
    fun resetPassword(): String {
        return "reset-password"
    }

}