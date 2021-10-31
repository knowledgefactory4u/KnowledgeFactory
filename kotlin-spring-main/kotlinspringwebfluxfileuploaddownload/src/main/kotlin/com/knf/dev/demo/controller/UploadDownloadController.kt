package com.knf.dev.demo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import reactor.core.publisher.Mono
import org.springframework.http.codec.multipart.FilePart
import java.lang.Void
import reactor.core.publisher.Flux
import java.nio.file.Paths

@RestController
@RequestMapping("api/v1")
class UploadDownloadController {
    private val basePath = Paths.
    get("./src/main/resources/files/")

    //single file upload
    @PostMapping("single/upload")
    fun uploadFile(@RequestPart("file") filePartMono:
                   Mono<FilePart>): Mono<Void> {
        return filePartMono
            .doOnNext { fp: FilePart ->
                println("Received File : " + fp.filename()) }
            .flatMap { fp: FilePart -> fp.
            transferTo(basePath.resolve(fp.filename())) }
            .then()
    }

    //multiple file upload
    @PostMapping("multi/upload")
    fun uploadMultipleFiles(@RequestPart("files") partFlux:
                            Flux<FilePart>): Mono<Void> {
        return partFlux
            .doOnNext { fp: FilePart ->
                println(fp.filename()) }
            .flatMap { fp: FilePart -> fp.
            transferTo(basePath.resolve(fp.filename())) }
            .then()
    }
}