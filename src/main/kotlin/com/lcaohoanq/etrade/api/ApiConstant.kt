package com.lcaohoanq.etrade.api

import org.springframework.beans.factory.annotation.Value

object ApiConstant {
    
    @Value("\${api.prefix}")
    const val API_PREFIX: String = "/api/v1"

}