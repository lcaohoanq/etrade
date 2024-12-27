package com.lcaohoanq.etrade.exception

import lombok.NoArgsConstructor

@NoArgsConstructor
class InsufficientFundsException(message: String?) : RuntimeException(message)
