package com.devtiro.mongo.mappers.impl;

import com.devtiro.mongo.domain.CreateUpdateAuthorRequest;
import com.devtiro.mongo.domain.dtos.CreateUpdateAuthorRequestDto;
import com.devtiro.mongo.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper for going between CreateUpdateAuthorRequest and CreateUpdateAuthorRequestDtos.
 */
@Component
public class AuthorCreateUpdateRequestMapper implements Mapper<CreateUpdateAuthorRequest, CreateUpdateAuthorRequestDto> {
    @Override
    public CreateUpdateAuthorRequestDto mapTo(CreateUpdateAuthorRequest createUpdateAuthorRequest) {
        return CreateUpdateAuthorRequestDto.builder()
                .givenName(createUpdateAuthorRequest.getGivenName())
                .familyName(createUpdateAuthorRequest.getFamilyName())
                .description(createUpdateAuthorRequest.getDescription())
                .build();
    }

    @Override
    public CreateUpdateAuthorRequest mapFrom(CreateUpdateAuthorRequestDto createUpdateAuthorRequestDto) {
        return CreateUpdateAuthorRequest.builder()
                .givenName(createUpdateAuthorRequestDto.getGivenName())
                .familyName(createUpdateAuthorRequestDto.getFamilyName())
                .description(createUpdateAuthorRequestDto.getDescription())
                .build();
    }
}
