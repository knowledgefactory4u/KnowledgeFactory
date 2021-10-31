package com.knf.dev.demo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import kotlin.Throws
import java.io.IOException
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Mono
import java.lang.Void
import org.springframework.http.ZeroCopyHttpOutputMessage
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpResponse

@RestController
class DownloadFile {
    @GetMapping("/download/{fileName}")
    @Throws(IOException::class)
    fun downloadFile(
        @PathVariable fileName: String,
        response: ServerHttpResponse
    ): Mono<Void> {
        val zeroCopyResponse = response as ZeroCopyHttpOutputMessage
        response.getHeaders()[HttpHeaders.CONTENT_DISPOSITION] =
            "attachment; filename=$fileName"
        response.getHeaders().contentType = MediaType.APPLICATION_OCTET_STREAM
        val resource = ClassPathResource(fileName)
        val file = resource.file
        return zeroCopyResponse.writeWith(
            file, 0,
            file.length()
        )
    }
}