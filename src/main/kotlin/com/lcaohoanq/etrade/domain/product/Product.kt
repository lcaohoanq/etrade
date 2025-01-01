package com.lcaohoanq.etrade.domain.product

import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    val id: Long = 1,

    val name: String = "",

    val image: String = "",
    
    val price: Int = 0,

    @Column(name = "before_sale_price")
    val beforeSalePrice: Int = 0,

    val sale: Int = 0,

    ) {}