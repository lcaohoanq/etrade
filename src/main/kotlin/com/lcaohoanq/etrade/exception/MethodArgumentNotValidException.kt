package com.lcaohoanq.etrade.exception

import lombok.Getter
import org.springframework.validation.BindingResult

class MethodArgumentNotValidException(val bindingResult: BindingResult) :
    RuntimeException("Validation failed")
