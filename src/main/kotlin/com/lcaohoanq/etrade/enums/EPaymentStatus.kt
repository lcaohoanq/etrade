package com.lcaohoanq.etrade.enums

enum class EPaymentStatus(val status: String) {
    PENDING("PENDING"),
    SUCCESS("SUCCESS"),
    REFUNDED("REFUNDED"),
    ALL("ALL"); //for searching
}
