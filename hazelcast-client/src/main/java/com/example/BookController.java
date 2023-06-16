package com.example;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    private final static Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public ResponseEntity<Collection<Book>> findAll() {
        log.info("call bookService findAll()");
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        log.info("call bookService for create a book with isbn {}", book.getIsbn());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.add(book));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        log.info("call bookService with isbn {}", id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.find(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        log.info("call bookService for update a book with id {}", id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(bookService.update(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        log.info("call bookService for delete a book with id {}", id);
        bookService.remove(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> handleException(IllegalArgumentException ex) {
        ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        log.info("{} message: {}", ex.getClass().getName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(responseError);
    }

}