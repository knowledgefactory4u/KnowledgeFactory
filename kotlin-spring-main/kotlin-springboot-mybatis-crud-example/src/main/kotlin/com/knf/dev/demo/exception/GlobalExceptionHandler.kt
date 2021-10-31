package com.knf.dev.demo.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import com.knf.dev.demo.exception.UserIdNotFoundException
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import java.time.LocalDateTime
import org.springframework.http.HttpStatus
import com.knf.dev.demo.exception.UserIdAlreadyExistException
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(UserIdNotFoundException::class)
    fun globalExceptionHandler(ex: Exception, request: WebRequest?):
            ResponseEntity<CustomErrorResponse> {
        val errors = CustomErrorResponse()
        errors.timestamp = LocalDateTime.now()
        errors.error = ex.message
        errors.status = HttpStatus.NOT_FOUND.value()
        return ResponseEntity<CustomErrorResponse>(errors, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(UserIdAlreadyExistException::class)
    fun globalExceptionHandler2(ex: Exception, request: WebRequest?):
            ResponseEntity<CustomErrorResponse> {
        val errors = CustomErrorResponse()
        errors.timestamp = LocalDateTime.now()
        errors.error = ex.message
        errors.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        return ResponseEntity<CustomErrorResponse>(errors,
            HttpStatus.INTERNAL_SERVER_ERROR)
    }
}