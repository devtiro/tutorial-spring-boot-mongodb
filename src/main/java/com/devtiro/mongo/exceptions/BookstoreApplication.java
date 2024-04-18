package com.devtiro.mongo.exceptions;

/**
 * Base exception for the whole Bookstore application.
 * Note that we extend RuntimeException here. For the full
 * argument on why we may choose unchecked exceptions over
 * checked exceptions, check out the Clean Code book!
 */
public class BookstoreApplication extends RuntimeException {
    public BookstoreApplication() {
    }

    public BookstoreApplication(String message) {
        super(message);
    }

    public BookstoreApplication(String message, Throwable cause) {
        super(message, cause);
    }

}
