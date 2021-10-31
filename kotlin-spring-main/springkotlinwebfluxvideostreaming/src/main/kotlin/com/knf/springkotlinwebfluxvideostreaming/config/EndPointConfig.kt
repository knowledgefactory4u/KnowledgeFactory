package com.knf.springkotlinwebfluxvideostreaming.config


import com.knf.springkotlinwebfluxvideostreaming.service.VideoStreamingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

@Configuration
class EndPointConfig {
    @Autowired
    private val service: VideoStreamingService? = null
    @Bean
    fun router(): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .GET(
                "video/{name}",
                HandlerFunction<ServerResponse> { serverRequest: ServerRequest -> videoHandler(serverRequest) })
            .build()
    }

    private fun videoHandler(serverRequest: ServerRequest): Mono<ServerResponse> {
        val title: String = serverRequest.pathVariable("name")
        return ServerResponse.ok()
            .contentType(MediaType.valueOf("video/mp4"))
            .body(service!!.getVideo(title), Resource::class.java)
    }
}