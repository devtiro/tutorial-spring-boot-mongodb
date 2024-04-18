package com.devtiro.mongo.domain.dtos;

import com.devtiro.mongo.domain.documents.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An author of a {@link Book}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    /**
     * The ID of the author.
     * This is an oid determined by MongoDB.
     * e.g. "5ff1e194b4f39b6e52a8314f".
     */
    private String id;

    /**
     * The author's given name.
     * e.g. "Jane".
     */
    private String givenName;

    /**
     * The author's family name.
     * e.g. "Austen".
     */
    private String familyName;


    /**
     * A short description of the author.
     * e.g. "Jane Austen (1775–1817) was an English novelist known for her wit,
     *       social commentary, and keen insight into the lives of the British
     *       landed gentry during the late 18th and early 19th centuries."
     */
    private String description;

}
