package com.devtiro.mongo.domain;

import com.devtiro.mongo.domain.documents.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthoredBook {
    /**
     * The International Standard Book Number or unique identifier of the book.
     * e.g."978-1-234567-89-0".
     */
    @Id
    private String isbn;

    /**
     * The title of the book.
     * e.g. "Pride and Prejudice".
     */
    private String title;

    /**
     * The date the book was published.
     */
    private LocalDate datePublished;

    /**
     * The book's author.
     */
    private Author author;

    /**
     * The date and time the book was created.
     */
    private LocalDateTime created;

    /**
     * The date and time the book was last updated.
     */
    private LocalDateTime lastUpdated;
}
