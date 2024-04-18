package com.devtiro.mongo.services.impl;

import com.devtiro.mongo.domain.CreateUpdateAuthorRequest;
import com.devtiro.mongo.domain.documents.Author;
import com.devtiro.mongo.repositories.AuthorRepository;
import com.devtiro.mongo.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> listAuthors() {
        // Ask the repository to give us all the Authors!
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createUpdateAuthor(final String authorId, final CreateUpdateAuthorRequest createUpdateAuthorRequest) {
        return authorRepository.findById(authorId).map(
                existingAuthor -> {
                    // Update the existing Author
                    final Author updatedAuthor = Author.builder()
                            .id(authorId)
                            .givenName(createUpdateAuthorRequest.getGivenName())
                            .familyName(createUpdateAuthorRequest.getFamilyName())
                            .description(createUpdateAuthorRequest.getDescription())
                            .created(existingAuthor.getCreated())
                            .lastUpdated(LocalDateTime.now())
                            .build();
                    return authorRepository.save(updatedAuthor);
                }).orElseGet(() -> {
            // Create a new Author
            final LocalDateTime now = LocalDateTime.now();
            final Author newAuthor = Author.builder()
                    .id(authorId)
                    .givenName(createUpdateAuthorRequest.getGivenName())
                    .familyName(createUpdateAuthorRequest.getFamilyName())
                    .description(createUpdateAuthorRequest.getDescription())
                    .created(now)
                    .lastUpdated(now)
                    .build();
            return authorRepository.save(newAuthor);
        });
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }
}
