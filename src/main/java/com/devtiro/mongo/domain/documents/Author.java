package com.devtiro.mongo.domain.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

/**
 * An author of a {@link Book}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    /**
     * The ID of the author.
     * This is an oid determined by MongoDB.
     * e.g. "5ff1e194b4f39b6e52a8314f".
     */
    @Id
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

    /**
     * The date and time the author was created.
     */
    private LocalDateTime created;

    /**
     * The time and date the author was last created.
     */
    private LocalDateTime lastUpdated;

}
