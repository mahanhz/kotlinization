package com.example.clean.app.web.controller.exception

import com.example.clean.app.web.controller.ControllerPackageMarker
import com.example.clean.app.web.controller.MediaTypes
import com.example.clean.app.web.controller.exception.VndErrorFactory.vndErrors
import com.fasterxml.uuid.Generators
import org.slf4j.LoggerFactory
import org.springframework.hateoas.VndErrors
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

const val ERROR_ID = "errorId"
const val ERROR = "error"
const val STATUS = "status"
const val PATH = "path"
const val MESSAGE = "message"
const val TIMESTAMP = "timestamp"

@RestControllerAdvice(basePackageClasses = arrayOf(ControllerPackageMarker::class))
class GlobalExceptionHandlerController {

    private val LOGGER = LoggerFactory.getLogger(GlobalExceptionHandlerController::class.java)

    @ExceptionHandler
    fun handleException(request: HttpServletRequest,
                        response: HttpServletResponse,
                        throwable: Throwable): ResponseEntity<VndErrors> {

        val httpStatus = HttpStatus.valueOf(response.status)

        return ResponseEntity(vndErrors(errorAttributes(request, response, httpStatus, throwable)),
                              headers(),
                              httpStatus)
    }

    private fun headers(): HttpHeaders {
        val headers = HttpHeaders()
        headers.contentType = MediaTypes.APPLICATION_VND_ERROR_JSON
        return headers
    }

    private fun errorAttributes(request: HttpServletRequest,
                                response: HttpServletResponse,
                                httpStatus: HttpStatus,
                                throwable: Throwable): Map<String, String> {
        val errorId = Generators.timeBasedGenerator().generate()
        LOGGER.error("ErrorId: {} references the following error: ", errorId, throwable)

        val errorMap = HashMap<String, String>()
        errorMap.put(ERROR_ID, errorId.toString())
        errorMap.put(ERROR, "Oops! Something went wrong!")
        errorMap.put(STATUS, httpStatus.toString())
        errorMap.put(PATH, request.requestURI)
        errorMap.put(MESSAGE, "Record the errorId when reporting this issue")
        errorMap.put(TIMESTAMP, Date().toString())

        return errorMap
    }
}