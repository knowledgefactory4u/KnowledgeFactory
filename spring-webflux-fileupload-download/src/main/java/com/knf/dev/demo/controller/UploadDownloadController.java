package com.knf.dev.demo.controller;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/v1")
public class UploadDownloadController {

    private final Path basePath = Paths.
            get("./src/main/resources/files/");

    //single file upload
    @PostMapping("single/upload")
    public Mono<Void> uploadFile(@RequestPart("file")
                                             Mono<FilePart> filePartMono){
               return  filePartMono
                .doOnNext(fp -> System.out.println
                        ("Received File : " + fp.filename()))
                .flatMap(fp -> fp.
                        transferTo(basePath.resolve(fp.filename())))
                .then();
    }

    //multiple file upload
    @PostMapping("multi/upload")
    public Mono<Void> uploadMultipleFiles(@RequestPart("files")
                                                      Flux<FilePart> partFlux){
        return  partFlux
                .doOnNext(fp ->
                        System.out.println(fp.filename()))
                .flatMap(fp ->
                        fp.transferTo(basePath.resolve(fp.filename())))
                .then();
    }
}
