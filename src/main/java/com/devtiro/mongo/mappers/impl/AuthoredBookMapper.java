package com.devtiro.mongo.mappers.impl;

import com.devtiro.mongo.domain.AuthoredBook;
import com.devtiro.mongo.domain.documents.Author;
import com.devtiro.mongo.domain.dtos.AuthorDto;
import com.devtiro.mongo.domain.dtos.AuthoredBookDto;
import com.devtiro.mongo.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthoredBookMapper implements Mapper<AuthoredBook, AuthoredBookDto> {

    private final Mapper<Author, AuthorDto> authorMapper;

    @Override
    public AuthoredBookDto mapTo(final AuthoredBook book) {
        return AuthoredBookDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .datePublished(book.getDatePublished())
                .author(authorMapper.mapTo(book.getAuthor()))
                .build();
    }

    @Override
    public AuthoredBook mapFrom(final AuthoredBookDto authoredBookDto) {
        return AuthoredBook.builder()
                .isbn(authoredBookDto.getIsbn())
                .title(authoredBookDto.getTitle())
                .datePublished(authoredBookDto.getDatePublished())
                .author(authorMapper.mapFrom(authoredBookDto.getAuthor()))
                .build();
    }
}
