package com.lcaohoanq.etrade.domain.page.blog

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BlogController {
    
    @GetMapping("/blog")
    fun entryPoint(): String {
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
    
}