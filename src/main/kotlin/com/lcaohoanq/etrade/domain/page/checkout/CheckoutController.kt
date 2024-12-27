package com.lcaohoanq.etrade.domain.page.checkout

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CheckoutController {
    
    @GetMapping("/checkout")
    fun entryPoint(): String {
        return "checkout"
    }
    
}