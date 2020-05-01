package com.amit.error;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RestApiError implements Serializable{
	 
	private static final long serialVersionUID = -3067934464157525860L;

	private HttpStatus status;
    private String message;
    private List<String> errors;
 
    public RestApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
 
    public RestApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}