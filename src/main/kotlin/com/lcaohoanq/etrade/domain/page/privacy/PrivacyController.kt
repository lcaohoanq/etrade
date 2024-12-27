package com.lcaohoanq.etrade.domain.page.privacy

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PrivacyController {
    @GetMapping("/privacy-policy")
    fun entryPoint(): String {
        return "privacy-policy"
    }
    
    @GetMapping("/terms-of-service")
    fun termsOfService(): String {
        return "terms-of-service"
    }
    
}