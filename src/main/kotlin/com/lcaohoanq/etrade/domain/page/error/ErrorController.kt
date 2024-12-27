package com.lcaohoanq.etrade.domain.page.error

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ErrorController {
    
    @GetMapping("404")
    fun error404(): String {
        return "404"
    }
    
}