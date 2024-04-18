package com.devtiro.mongo.domain.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A book written by an {@link Author}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

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
     * The ID of the author.
     * This is the oid of the author in the author's Mongo collection.
     * e.g. "5ff1e194b4f39b6e52a8314f".
     */
    private String authorId;

    /**
     * The date and time the book was created.
     */
    private LocalDateTime created;

    /**
     * The date and time the book was last updated.
     */
    private LocalDateTime lastUpdated;

}
