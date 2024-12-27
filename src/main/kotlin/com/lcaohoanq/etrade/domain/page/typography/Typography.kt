package com.lcaohoanq.etrade.domain.page.typography

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Typography {
    
    @GetMapping("/typography")
    fun entryPoint(): String {
        return "typography"
    }
    
}