package com.lcaohoanq.etrade.domain.page.wishlist

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WishlistController {
    
    @GetMapping("/wishlist")
    fun entryPoint(): String {
        return "wishlist"
    }
    
}