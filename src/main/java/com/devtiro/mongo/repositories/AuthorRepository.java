package com.devtiro.mongo.repositories;

import com.devtiro.mongo.domain.documents.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
