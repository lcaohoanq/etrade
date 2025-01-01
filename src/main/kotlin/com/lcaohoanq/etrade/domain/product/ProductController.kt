package com.lcaohoanq.etrade.domain.product

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductApiController {

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(
            listOf(
                Product(1L, "Product 1", "hinh1.jpg", 100, 10, 10),
                Product(2L, "Product 2", "hinh2.jpg", 200, 20, 20),
            )
        )
    }


}