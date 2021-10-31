package com.knf.dev.handler

import org.springframework.web.socket.TextMessage
import org.json.JSONException
import org.json.JSONObject
import org.springframework.stereotype.Component
import java.io.IOException
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class TextHandler : TextWebSocketHandler() {
    @Throws(InterruptedException::class, IOException::class, JSONException::class)
    public override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val payload = message.payload
        val jsonObject = JSONObject(payload)
        session.sendMessage(TextMessage("Your message:" + jsonObject.get("user")))
    }
}