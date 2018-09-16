package net.joaolourenco.common.exceptions;

import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;

    private final String[] params;
    private List<FieldError> fieldErrors;

    public Error(String message) {
        this(message, null);
    }

    public Error(String message, String description) {
        this.message = message;
        this.description = description;
        this.fieldErrors = null;
        this.params = null;
    }

    public Error(String message, String description, String... params) {
        this.message = message;
        this.description = description;
        this.fieldErrors = null;
        this.params = params;
    }

    public Error(String message, String description, List<FieldError> fieldErrors) {
        this.message = message;
        this.description = description;
        this.fieldErrors = fieldErrors;
        this.params = null;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldError(objectName, field, message));
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public String[] getParams() {
        return params;
    }

}
