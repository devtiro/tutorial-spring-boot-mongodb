package com.devtiro.mongo.mappers.impl;

import com.devtiro.mongo.domain.documents.Author;
import com.devtiro.mongo.domain.dtos.AuthorDto;
import com.devtiro.mongo.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper for going between Authors and AuthorDtos.
 */
@Component
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public AuthorDto mapTo(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .givenName(author.getGivenName())
                .familyName(author.getFamilyName())
                .description(author.getDescription())
                .build();
    }

    @Override
    public Author mapFrom(AuthorDto authorDto) {
        return Author.builder()
                .id(authorDto.getId())
                .givenName(authorDto.getGivenName())
                .familyName(authorDto.getFamilyName())
                .description(authorDto.getDescription())
                .build();
    }
}
