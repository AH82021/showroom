package com.armancodeblock.carShow.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }


}
