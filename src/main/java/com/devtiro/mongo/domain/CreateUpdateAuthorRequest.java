package com.devtiro.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A request to create or update an Author.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateAuthorRequest {

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
