package com.lcaohoanq.etrade.domain.page.index

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/test")
    fun entryPoint(): String {
        return "/"
    }
    
}

@Controller
class Index1Controller {

    @GetMapping("/index-1")
    fun entryPoint(): String {
        return "index-1"
    }

}

@Controller
class Index2Controller {

    @GetMapping("/index-2")
    fun entryPoint(): String {
        return "index-2"
    }

}

@Controller
class Index3Controller {

    @GetMapping("/index-3")
    fun entryPoint(): String {
        return "index-3"
    }

}

@Controller
class Index4Controller {

    @GetMapping("/index-4")
    fun entryPoint(): String {
        return "index-4"
    }

}

@Controller
class Index5Controller {

    @GetMapping("/index-5")
    fun entryPoint(): String {
        return "index-5"
    }

}

@Controller
class Index6Controller {

    @GetMapping("/index-6")
    fun entryPoint(): String {
        return "index-6"
    }

}

@Controller
class Index7Controller {

    @GetMapping("/index-7")
    fun entryPoint(): String {
        return "index-7"
    }

}