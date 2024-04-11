package me.dio.sdw24.adapters.in.exception;

import me.dio.sdw24.domain.model.exception.ChampionsNotFoundException;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler(ChampionsNotFoundException.class)
//   public ResponseEntity<ApiError> handleDomainException(ChampionsNotFoundException domainError){
//        return ResponseEntity
//                .unprocessableEntity()
//                .body(new ApiError(domainError.getMessage()));
//   }


    @ExceptionHandler(ChampionsNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(Exception unexpectedError){
        return ResponseEntity
                .internalServerError()
                .body(new ApiError("Erro inesperado"));
   }

   public record ApiError(String message){}
}
