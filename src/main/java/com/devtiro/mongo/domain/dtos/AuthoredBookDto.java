package com.devtiro.mongo.domain.dtos;

import com.devtiro.mongo.domain.documents.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * A book written by an {@link Author}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthoredBookDto {

    private String isbn;

    private String title;

    private LocalDate datePublished;

    private AuthorDto author;

}
