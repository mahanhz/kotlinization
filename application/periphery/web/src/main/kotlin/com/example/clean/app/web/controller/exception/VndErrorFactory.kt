package com.example.clean.app.web.controller.exception

import com.example.clean.app.web.controller.CommonLinks.homeLink
import org.springframework.hateoas.VndErrors
import kotlin.streams.toList


object VndErrorFactory {

    fun vndErrors(errorAttributes: Map<String, String>): VndErrors {
        val vndErrors = errorAttributes.entries.stream()
                .map { vndError(it) }
                .toList()

        return VndErrors(vndErrors)
    }

    private fun vndError(entry: Map.Entry<String, String>): VndErrors.VndError {
        return VndErrors.VndError(entry.key, entry.value, homeLink())
    }
}