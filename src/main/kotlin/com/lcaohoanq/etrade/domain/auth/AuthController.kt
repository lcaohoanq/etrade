package com.lcaohoanq.etrade.domain.auth

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController {
    
    @GetMapping("sign-in")
    fun signIn(): String {
        return "sign-in"
    }
    
    @GetMapping("sign-up")
    fun signUp(): String {
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