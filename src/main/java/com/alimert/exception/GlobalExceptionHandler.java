package com.alimert.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Field;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorsMap = new HashMap<>();
        for (ObjectError allError : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) allError).getField();
            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue((errorsMap.get(fieldName)), allError.getDefaultMessage()));
            } else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), allError.getDefaultMessage()));
            }
        }
        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private <T> ApiError<T> createApiError(T errors) {
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }
}