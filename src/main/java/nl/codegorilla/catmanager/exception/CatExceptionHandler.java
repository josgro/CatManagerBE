package nl.codegorilla.catmanager.exception;

import nl.codegorilla.catmanager.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CatExceptionHandler {
    @ExceptionHandler(CatNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleCatNotFoundException(CatNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
