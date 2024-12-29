package com.lcaohoanq.etrade.domain.asset

import com.lcaohoanq.etrade.domain.auth.AuthPort
import com.lcaohoanq.etrade.domain.user.IUserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AssetController(
    private val userService: IUserService
) {

    @GetMapping("/test")
    fun test(): String {
        return "/"
    }

    @GetMapping("/index-1")
    fun index1(): String {
        return "index-1"
    }

    @GetMapping("/index-2")
    fun index2(): String {
        return "index-2"
    }

    @GetMapping("/index-3")
    fun index3(): String {
        return "index-3"
    }

    @GetMapping("/index-4")
    fun index4(): String {
        return "index-4"
    }

    @GetMapping("/index-5")
    fun index5(): String {
        return "index-5"
    }

    @GetMapping("/index-6")
    fun index6(): String {
        return "index-6"
    }

    @GetMapping("/index-7")
    fun index7(): String {
        return "index-7"
    }

    @GetMapping("sign-in")
    fun signIn(model: Model): String {
        model.addAttribute("login", AuthPort.UserLoginDTO())
        return "sign-in"
    }

    @GetMapping("sign-up")
    fun signUp(model: Model): String {
        model.addAttribute("register", AuthPort.AccountRegisterDTO())
        return "sign-up"
    }

    @GetMapping("/my-account")
    fun myAccount(): String {
        return "my-account"
    }

    @GetMapping("/privacy-policy")
    fun privacyPolicy(): String {
        return "privacy-policy"
    }

    @GetMapping("/terms-of-service")
    fun termsOfService(): String {
        return "terms-of-service"
    }

    @GetMapping("/single-product")
    fun singleProduct(): String {
        return "single-product"
    }

    @GetMapping("/single-product-2")
    fun singleProduct2(): String {
        return "single-product-2"
    }

    @GetMapping("/single-product-3")
    fun singleProduct3(): String {
        return "single-product-3"
    }

    @GetMapping("/single-product-4")
    fun singleProduct4(): String {
        return "single-product-4"
    }

    @GetMapping("/single-product-5")
    fun singleProduct5(): String {
        return "single-product-5"
    }

    @GetMapping("/single-product-6")
    fun singleProduct6(): String {
        return "single-product-6"
    }

    @GetMapping("/single-product-7")
    fun singleProduct7(): String {
        return "single-product-7"
    }

    @GetMapping("/single-product-8")
    fun singleProduct8(): String {
        return "single-product-8"
    }
    
    @GetMapping("forgot-password")
    fun forgotPassword(): String {
        return "forgot-password"
    }

    @GetMapping("reset-password")
    fun resetPassword(): String {
        return "reset-password"
    }

    @GetMapping("/about-us")
    fun aboutUs(): String {
        println("Hello")
        return "about-us"
    }

    @GetMapping("/shop")
    fun shop(): String {
        return "shop"
    }

    @GetMapping("/shop-sidebar")
    fun shopSideBar(): String {
        return "shop-sidebar"
    }

    @GetMapping("/typography")
    fun typography(): String {
        return "typography"
    }

    @GetMapping("/wishlist")
    fun wishlist(): String {
        return "wishlist"
    }

    @GetMapping("/blog")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("blog-grid")
    fun blogGrid(): String {
        return "blog-grid"
    }

    @GetMapping("/blog-details")
    fun blogDetails(): String {
        return "blog-details"
    }

    @GetMapping("blog-gallery")
    fun blogGallery(): String {
        return "blog-gallery"
    }

    @GetMapping("blog-video")
    fun blogVideo(): String {
        return "blog-video"
    }

    @GetMapping("blog-audio")
    fun blogAudio(): String {
        return "blog-audio"
    }

    @GetMapping("blog-quote")
    fun blogQuote(): String {
        return "blog-quote"
    }

    @GetMapping("/cart")
    fun cart(): String {
        return "cart"
    }

    @GetMapping("/checkout")
    fun checkOut(): String {
        return "checkout"
    }

    @GetMapping("/coming-soon")
    fun comingSoon(): String {
        return "coming-soon"
    }

    @GetMapping("/contact")
    fun contact(): String {
        return "contact"
    }

    @GetMapping("404")
    fun error404(): String {
        return "404"
    }
    
    //management
    @GetMapping("manage-users")
    fun getUserManagements(model: Model): String {
        val users = userService.getAllUsers() // Assume `userService` is your service to get all users.
        model.addAttribute("users", users)
        return "manage-users"
    }

    @GetMapping("manage-products")
    fun getProductManagements(): String {
        return "manage-products"
    }

}