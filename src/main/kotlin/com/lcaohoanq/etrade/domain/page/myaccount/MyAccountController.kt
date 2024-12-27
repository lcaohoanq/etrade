package com.lcaohoanq.etrade.domain.page.myaccount

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyAccountController {
    
    @GetMapping("/my-account")
    fun entryPoint(): String {
        return "my-account"
    }
    
}