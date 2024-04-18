package com.devtiro.mongo.mappers.impl;

import com.devtiro.mongo.domain.CreateUpdateBookRequest;
import com.devtiro.mongo.domain.dtos.CreateUpdateBookRequestDto;
import com.devtiro.mongo.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the Mapper interface to convert from a CreateBookRequest (service layer)
 * to the CreateUpdateBookRequestDto (presentation layer), and back again.
 */
@Component
public class BookCreateUpdateRequestMapper implements Mapper<CreateUpdateBookRequest, CreateUpdateBookRequestDto> {

    @Override
    public CreateUpdateBookRequestDto mapTo(final CreateUpdateBookRequest createUpdateBookRequest) {
        return CreateUpdateBookRequestDto.builder()
                .title(createUpdateBookRequest.getTitle())
                .authorId(createUpdateBookRequest.getAuthorId())
                .datePublished(createUpdateBookRequest.getDatePublished())
                .build();
    }

    @Override
    public CreateUpdateBookRequest mapFrom(final CreateUpdateBookRequestDto createUpdateBookRequestDto) {
        return CreateUpdateBookRequest.builder()
                .title(createUpdateBookRequestDto.getTitle())
                .authorId(createUpdateBookRequestDto.getAuthorId())
                .datePublished(createUpdateBookRequestDto.getDatePublished())
                .build();
    }
}
