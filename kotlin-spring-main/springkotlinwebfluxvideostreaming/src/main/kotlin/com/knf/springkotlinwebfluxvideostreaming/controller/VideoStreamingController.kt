package com.knf.springkotlinwebfluxvideostreaming.controller


import com.knf.springkotlinwebfluxvideostreaming.service.VideoStreamingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class VideoStreamingController {
    @Autowired
    private val service: VideoStreamingService? = null
    @GetMapping(value = ["video/{name}"], produces = ["video/mp4"])
    fun getVideo(
        @PathVariable title: String?,
        @RequestHeader("Range") range: String?
    ): Mono<Resource> {
        return service!!.getVideo(title)
    }
}