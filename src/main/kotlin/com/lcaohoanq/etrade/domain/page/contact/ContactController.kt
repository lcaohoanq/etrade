package com.lcaohoanq.etrade.domain.page.contact

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ContactController {
    
    @GetMapping("/contact")
    fun entryPoint(): String {
        return "contact"
    }
    
}