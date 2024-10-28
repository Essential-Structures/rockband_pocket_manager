package com.sabin.rockband_song_manager.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@Slf4j
@ControllerAdvice //general exception handler class
public class ExceptionHandleAdvizor {

    private ObjectMapper objectMapper;

    //ObjectMapper dependency injection via constructor
    public ExceptionHandleAdvizor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //method to handle invalidInputData exceptions
    @ExceptionHandler(InvalidInputDataException.class)
    public ResponseEntity<String> invalidInputDataException(InvalidInputDataException invalidInputDataException) {
        return new ResponseEntity<>(
                objectToString(Map.of("Invalid input data: ", invalidInputDataException.getMessage())),
                    HttpStatus.BAD_REQUEST
        );

    }

    //method to handle song not found exceptions
    @ExceptionHandler(SongNotFoundException.class)
    public ResponseEntity<String> songUnpersistException(SongNotFoundException songUnpersistException) {
        return new ResponseEntity<>(
                objectToString(Map.of("Invalid input data: ", songUnpersistException.getMessage())),
                HttpStatus.NOT_FOUND);
    }

    //convert exception to String, to display
    public String objectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info("Error processing the response object into a string");
            return ("Internal error");

        }


    }
}