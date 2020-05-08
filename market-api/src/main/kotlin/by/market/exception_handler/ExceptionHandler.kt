package by.market.exception_handler

import by.market.exception.database.DatabaseException
import by.market.exception.database.EntityNotFoundException
import by.market.exception.database.RequestInNotValidException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [EntityNotFoundException::class, RequestInNotValidException::class])
    fun handler(databaseException: DatabaseException, request: WebRequest): ResponseEntity<ExceptionWrapper> {
        return ResponseEntity
                .status(databaseException.getCode())
                .body(ExceptionWrapper(Date(), databaseException.getMsg(), databaseException.getCode().value()))
    }

    data class ExceptionWrapper(val time: Date, val message: String, val code: Int)

}