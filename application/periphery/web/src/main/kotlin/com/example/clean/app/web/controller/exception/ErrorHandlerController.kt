package com.example.clean.app.web.controller.exception

import com.example.clean.app.web.controller.APPLICATION_VND_ERROR_JSON_VALUE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ErrorAttributes
import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.hateoas.VndErrors
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

const val ERROR_PATH = "/error"

@RestController
class ErrorHandlerController @Autowired constructor(private val errorAttributes: ErrorAttributes) : ErrorController {

    @GetMapping(value = ERROR_PATH, produces = arrayOf(APPLICATION_VND_ERROR_JSON_VALUE))
    fun error(request: HttpServletRequest): ResponseEntity<VndErrors> {

        val errorStatus = getErrorStatus(request)
        val errors = convertErrorAttributes(request)

        return ResponseEntity.status(errorStatus).body(VndErrorFactory.vndErrors(errors))
    }

    override fun getErrorPath(): String {
        return ERROR_PATH
    }

    private fun errorAttributes(request: HttpServletRequest): Map<String, Any> {
        val requestAttributes = ServletRequestAttributes(request)

        return errorAttributes.getErrorAttributes(requestAttributes, false)
    }

    private fun convertErrorAttributes(request: HttpServletRequest): Map<String, String> {
        return errorAttributes(request).mapValues { it.value.toString() }
    }

    private fun getErrorStatus(request: HttpServletRequest): Int {
        return request.getAttribute("javax.servlet.error.status_code") as Int
    }
}