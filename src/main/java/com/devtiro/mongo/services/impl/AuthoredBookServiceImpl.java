package com.devtiro.mongo.services.impl;

import com.devtiro.mongo.domain.AuthoredBook;
import com.devtiro.mongo.domain.CreateUpdateBookRequest;
import com.devtiro.mongo.domain.documents.Author;
import com.devtiro.mongo.domain.documents.Book;
import com.devtiro.mongo.exceptions.AuthorNotFoundException;
import com.devtiro.mongo.repositories.AuthorRepository;
import com.devtiro.mongo.repositories.BookRepository;
import com.devtiro.mongo.services.AuthoredBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthoredBookServiceImpl implements AuthoredBookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthoredBook> listBooks() {
        // Retrieve all the books
        final List<Book> allBooks = bookRepository.findAll();

        // Get the IDs of all the authors
        final List<String> authorIds = allBooks.stream().map(Book::getAuthorId).toList();

        // Make a single request to get all the relevant Authors
        // This is more efficient that make a request per book
        final List<Author> authors = authorRepository.findAllById(authorIds);

        // Create an index of all the authors using their ID
        // This gives us fast access
        final Map<String, Author> authorIndex = authors.stream()
                .collect(Collectors.toMap(Author::getId, author -> author));

        // Create an AuthoredBook with the Author and the Book
        return allBooks.stream().map(book -> {
            final String authorId = book.getAuthorId();
            final Author author = authorIndex.get(authorId);
            if (null == author) {
                throw new AuthorNotFoundException(authorId);
            }
            return buildAuthoredBook(book, author);
        }).toList();
    }

    @Override
    public Optional<AuthoredBook> getBookByIsbn(final String isbn) {
        return bookRepository.findById(isbn).map(book -> {
            final String authorId = book.getAuthorId();
            final Author author = authorRepository.findById(authorId).orElseThrow(() ->
                    new AuthorNotFoundException(authorId)
            );

            return buildAuthoredBook(book, author);
        });
    }

    @Override
    public AuthoredBook createUpdateBook(final String isbn, final CreateUpdateBookRequest createUpdateBookRequest) {
        final String authorId = createUpdateBookRequest.getAuthorId();

        // Ensure the author exists, otherwise throw an exception
        // Every book must have an Author!
        final Optional<Author> existingAuthor = authorRepository.findById(authorId);
        if (existingAuthor.isEmpty()) {
            throw new AuthorNotFoundException(authorId);
        }

        final Book book = bookRepository.findById(isbn).map(existingBook -> {
            // Update the existing Book
            final Book updatedBook = Book.builder()
                    .isbn(isbn)
                    .title(createUpdateBookRequest.getTitle())
                    .datePublished(createUpdateBookRequest.getDatePublished())
                    .authorId(authorId)
                    .created(existingBook.getCreated())
                    .lastUpdated(LocalDateTime.now())
                    .build();
            return bookRepository.save(updatedBook);
        }).orElseGet(() -> {
            // Create a new Book
            final LocalDateTime now = LocalDateTime.now();
            final Book newBook = Book.builder()
                    .isbn(isbn)
                    .title(createUpdateBookRequest.getTitle())
                    .datePublished(createUpdateBookRequest.getDatePublished())
                    .authorId(authorId)
                    .created(now)
                    .lastUpdated(now)
                    .build();
            return bookRepository.save(newBook);
        });

        return buildAuthoredBook(book, existingAuthor.get());
    }

    @Override
    public void deleteBook(final String isbn) {
        bookRepository.deleteById(isbn);
    }

    private AuthoredBook buildAuthoredBook(final Book book, final Author author) {
        return AuthoredBook.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .datePublished(book.getDatePublished())
                .author(author)
                .created(book.getCreated())
                .lastUpdated(book.getLastUpdated())
                .build();
    }
}
