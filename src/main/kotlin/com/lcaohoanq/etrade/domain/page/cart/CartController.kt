package com.lcaohoanq.etrade.domain.page.cart

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CartController {
    
    @GetMapping("/cart")
    fun entryPoint(): String {
        return "cart"
    }
    
}