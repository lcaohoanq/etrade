package com.lcaohoanq.etrade.repository

import com.lcaohoanq.etrade.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>{
}