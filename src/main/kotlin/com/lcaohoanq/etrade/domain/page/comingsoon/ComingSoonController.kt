package com.lcaohoanq.etrade.domain.page.comingsoon

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ComingSoonController {
    
    @GetMapping("/coming-soon")
    fun entryPoint(): String {
        return "coming-soon"
    }
    
}