package com.lcaohoanq.etrade

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.awt.Desktop
import java.io.IOException
import java.net.URI
import java.util.*

@SpringBootApplication
class KotlinEtradeApplication

fun main(args: Array<String>) {
    runApplication<KotlinEtradeApplication>(*args)
    openHomePage()
//    openHomePage("http://localhost:8080/swagger-ui/index.html")
}

@Throws(IOException::class)
private fun openHomePage(url: String = "http://localhost:8080/index-1") {
    try {
        // Check if the desktop is supported and can open the default browser
        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(URI(url))
            }
        } else {
            // Fallback for platforms that don't support Desktop
            val os = System.getProperty("os.name").lowercase(Locale.getDefault())
            if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler $url")
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open $url")
            } else if (os.contains("nix") || os.contains("nux")) {
                Runtime.getRuntime().exec("xdg-open $url")
            } else {
                println("Unsupported operating system: $os")
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
