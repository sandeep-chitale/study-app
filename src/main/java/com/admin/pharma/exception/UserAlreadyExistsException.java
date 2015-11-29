package com.admin.pharma.exception;

/**
 * Created by DELL on 11/29/2015.
 */
public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
