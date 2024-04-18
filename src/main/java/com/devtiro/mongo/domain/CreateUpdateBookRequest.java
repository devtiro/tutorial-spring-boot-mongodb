package com.devtiro.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * A representation of a book use to create or update a book in the database.
 * This a service layer domain object and used exclusively in the service layer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBookRequest {

    /**
     * The title of the book
     * e.g. "Pride and Prejudice".
     */
    private String title;

    /**
     * The date the book was published.
     * e.g. "1813-01-28".
     */
    private LocalDate datePublished;

    /**
     * The ID of the author
     * e.g. "d3e3c379-32cb-4a71-b962-3522b0ddc6e7".
     */
    private String authorId;

}