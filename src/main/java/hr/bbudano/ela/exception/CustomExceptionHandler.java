package hr.bbudano.ela.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ ElaException.class })
    public ResponseEntity<ErrorResponse> handleUrlShortenerException(final ElaException ex,
                                                                     WebRequest request) {
        log.error("Exception caught by controller advice", ex);

        var errorResponse = new ErrorResponse(
                ex.getHttpStatus(),
                Collections.singletonList(ex.getMessage()),
                ((ServletWebRequest) request).getRequest().getRequestURI()
        );

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex,
                                                                               WebRequest request) {
        var errors = ex
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errors,
                ((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorResponse.getStatus()));
    }

}
