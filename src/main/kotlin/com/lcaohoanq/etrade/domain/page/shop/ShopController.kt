package com.lcaohoanq.etrade.domain.page.shop

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ShopController {
    
    @GetMapping("/shop")
    fun entryPoint(): String {
        return "shop"
    }
    
    @GetMapping("/shop-sidebar")
    fun shopSideBar(): String {
        return "shop-sidebar"
    }
    
}