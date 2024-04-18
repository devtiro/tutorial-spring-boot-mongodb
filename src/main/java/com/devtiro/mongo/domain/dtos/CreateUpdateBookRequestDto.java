package com.devtiro.mongo.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * A representation of a book use to create or update a book in the database.
 * This is a Domain Transfer Object (DTO) and used exclusively in the presentation layer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBookRequestDto {

    private String title;

    private String authorId;

    private LocalDate datePublished;

}
