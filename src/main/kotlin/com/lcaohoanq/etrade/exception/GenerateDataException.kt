package com.lcaohoanq.etrade.exception

import lombok.NoArgsConstructor

@NoArgsConstructor
class GenerateDataException(message: String?) : RuntimeException(message)
