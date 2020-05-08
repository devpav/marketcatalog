package by.market.exception.database

import org.springframework.http.HttpStatus

interface DatabaseException {

    fun getMsg(): String

    fun getCode(): HttpStatus

}

open class EntityNotFoundException(
        override val message: String,
        private val code: HttpStatus = HttpStatus.NOT_FOUND
) : java.lang.RuntimeException(message), DatabaseException {

    override fun getCode(): HttpStatus = code

    override fun getMsg(): String = message

}

open class RequestInNotValidException(
        override val message: String,
        private val code: HttpStatus = HttpStatus.BAD_REQUEST
) : java.lang.RuntimeException(message), DatabaseException {

    override fun getCode(): HttpStatus = code

    override fun getMsg(): String = message

}