package com.devtiro.mongo.controllers;

import com.devtiro.mongo.domain.CreateUpdateAuthorRequest;
import com.devtiro.mongo.domain.documents.Author;
import com.devtiro.mongo.domain.dtos.AuthorDto;
import com.devtiro.mongo.domain.dtos.CreateUpdateAuthorRequestDto;
import com.devtiro.mongo.mappers.Mapper;
import com.devtiro.mongo.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/authors")
public class AuthorsController {

    private AuthorService authorService;

    private Mapper<Author, AuthorDto> authorMapper;

    private Mapper<CreateUpdateAuthorRequest, CreateUpdateAuthorRequestDto> createUpdateRequestMapper;

    @GetMapping
    public List<AuthorDto> listAuthors() {
        return authorService.listAuthors()
                .stream()
                .map(authorMapper::mapTo)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable final String id) {
        return authorService.getAuthorById(id)
                .map(author ->
                        // Map the Author to a AuthorDTO
                        // and return it
                        ResponseEntity.ok(authorMapper.mapTo(author))
                )
                .orElseGet(() ->
                        // Return HTTP 404 NOT FOUND
                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
                );
    }

    @PutMapping(path = "/{id}")
    public AuthorDto createUpdateAuthor(
            @PathVariable final String id,
            @RequestBody final CreateUpdateAuthorRequestDto requestBody
    ) {
        // Convert from the create/update Author request presentation layer to service layer object.
        final CreateUpdateAuthorRequest createUpdateAuthorRequest = createUpdateRequestMapper.mapFrom(requestBody);

        // Pass the converted object to the service layer to create/update the Author.
        final Author createUpdatedAuthor = authorService.createUpdateAuthor(id, createUpdateAuthorRequest);

        // Map the returned Author to a presentation layer object and return.
        return authorMapper.mapTo(createUpdatedAuthor);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable final String id) {
        authorService.deleteAuthor(id);
    }
}
