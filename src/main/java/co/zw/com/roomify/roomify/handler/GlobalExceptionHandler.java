package co.zw.com.roomify.roomify.handler;

import co.zw.com.roomify.roomify.dto.common.ErrorResponse;
import co.zw.com.roomify.roomify.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApi(ApiException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(ErrorResponse.of(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(e -> e.getField() + " " + e.getDefaultMessage())
                .orElse("Validation failed");
        return ResponseEntity.badRequest().body(ErrorResponse.of("VALIDATION_ERROR", msg));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknown(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(ErrorResponse.of("INTERNAL_ERROR", "An unexpected error occurred"));
    }
}
