package com.knf.springkotlinwebfluxvideostreaming.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import reactor.core.publisher.Mono
import com.knf.springkotlinwebfluxvideostreaming.service.VideoStreamingService
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class VideoStreamingService {
    @Autowired
    private val resourceLoader: ResourceLoader? = null
    fun getVideo(title: String?): Mono<Resource> {
        return Mono.fromSupplier { resourceLoader!!.getResource(String.format(FORMAT, title)) }
    }

    companion object {
        private const val FORMAT = "classpath:mp4/%s.mp4"
    }
}