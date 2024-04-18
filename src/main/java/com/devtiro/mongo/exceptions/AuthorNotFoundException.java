package com.devtiro.mongo.exceptions;

import lombok.Getter;

/**
 * Exception thrown when we look for an Author and it doesn't exist.
 * We don't use Lombok for constructors here as exception constructors
 * are quite particular.
 */
public class AuthorNotFoundException extends BookstoreApplication {

    private static final String ERROR_MESSAGE = "An Author with ID '%s' does not exist";

    @Getter
    private String authorId;

    public AuthorNotFoundException(final String authorId) {
        super(String.format(ERROR_MESSAGE, authorId));
        this.authorId = authorId;
    }

    public AuthorNotFoundException(final String authorId, final Throwable cause) {
        super(String.format(ERROR_MESSAGE, authorId), cause);
        this.authorId = authorId;
    }
}
