package com.knf.dev.deno.springwebfluxfiledownload.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.io.File;
import java.io.IOException;

@RestController
public class DownloadFile {

    @GetMapping("/download/{fileName}")
    public Mono<Void> downloadFile(@PathVariable String fileName,
                                   ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse =
                (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename="+fileName+"");
        response.getHeaders().setContentType(MediaType.
                APPLICATION_OCTET_STREAM);
        ClassPathResource resource = new ClassPathResource(fileName);
        File file = resource.getFile();
        return zeroCopyResponse.writeWith(file, 0,
                file.length());
    }
}
