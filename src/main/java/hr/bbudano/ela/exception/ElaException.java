package hr.bbudano.ela.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ElaException extends RuntimeException {

    private final HttpStatus httpStatus;

    public ElaException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
