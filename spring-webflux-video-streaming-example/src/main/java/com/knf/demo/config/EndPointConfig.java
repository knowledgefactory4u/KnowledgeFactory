package com.knf.demo.config;
import com.knf.demo.service.VideoStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class EndPointConfig {
    @Autowired
    private VideoStreamingService service;

    @Bean
    public RouterFunction<ServerResponse> router(){
        return RouterFunctions.route()
                .GET("video/{name}", this::videoHandler)
                .build();
    }

    private Mono<ServerResponse> videoHandler(ServerRequest serverRequest){
        String title = serverRequest.pathVariable("name");
        return ServerResponse.ok()
                .contentType(MediaType.valueOf("video/mp4"))
                .body(this.service.getVideo(title), Resource.class);
    }

}
