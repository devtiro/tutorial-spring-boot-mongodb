package com.devtiro.mongo.services;

import com.devtiro.mongo.domain.CreateUpdateAuthorRequest;
import com.devtiro.mongo.domain.documents.Author;

import java.util.List;
import java.util.Optional;

/**
 * A service for managing Authors.
 */
public interface AuthorService {

    List<Author> listAuthors();

    Optional<Author> getAuthorById(String id);

    Author createUpdateAuthor(String authorId, CreateUpdateAuthorRequest createUpdateAuthorRequest);

    void deleteAuthor(String id);

}
