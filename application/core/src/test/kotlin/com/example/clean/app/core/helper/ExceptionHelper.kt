package com.example.clean.app.core.helper

object ExceptionHelper {

    fun valid(): Class<out Exception> {
        return NoException::class.java
    }

    fun invalidMatching(exception: Class<out Exception>): Class<out Exception> {
        return exception
    }
}
