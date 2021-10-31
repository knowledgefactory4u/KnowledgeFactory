package com.knf.dev.config

import com.knf.dev.handler.TextHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocket

@Configuration
@EnableWebSocket
class SocketConfig : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(TextHandler(), "/getMessage")
    }
}