package com.lcaohoanq.etrade.domain.page.aboutus

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutUsController {
    
    @GetMapping("/about-us")
    fun entryPoint(): String {
        return "about-us"
    }
    
}