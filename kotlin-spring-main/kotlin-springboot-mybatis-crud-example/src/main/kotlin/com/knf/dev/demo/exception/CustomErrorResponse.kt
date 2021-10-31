package com.knf.dev.demo.exception

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class CustomErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    var timestamp: LocalDateTime? = null
    var status = 0
    var error: String? = null
}