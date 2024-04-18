package com.devtiro.mongo.services;


import com.devtiro.mongo.domain.AuthoredBook;
import com.devtiro.mongo.domain.CreateUpdateBookRequest;

import java.util.List;
import java.util.Optional;

/**
 * A service for the managing of Books.
 */
public interface AuthoredBookService {
    List<AuthoredBook> listBooks();

    Optional<AuthoredBook> getBookByIsbn(String isbn);

    AuthoredBook createUpdateBook(String bookIsbn, CreateUpdateBookRequest createUpdateBookRequest);

    void deleteBook(String isbn);
}
