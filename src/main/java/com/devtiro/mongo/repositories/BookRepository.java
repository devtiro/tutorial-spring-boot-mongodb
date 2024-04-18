package com.devtiro.mongo.repositories;

import com.devtiro.mongo.domain.documents.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
