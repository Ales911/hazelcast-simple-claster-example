package com.example;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    
    @Autowired
    private HazelcastService hazelcastService;
    
    public Collection<Book> findAll() {
        logger.info("findAll(): ");
        return hazelcastService.getMapDev().values();
    }
    
    public Book add(Book book) {
        logger.info("add a book with isbn: " + book.getIsbn());
        Long id = hazelcastService.getNewId();
        book.setId(id);
        return hazelcastService.getMapDev().putIfAbsent(id, book);
    }
    
    public Book find(Long id) {
        logger.info("finding book by id: " + id);
        return hazelcastService.getMapDev().get(id);
    }
    
    public Book update(Long id, Book book) {
        logger.info("update book with isbn: " + book.getIsbn());
        return hazelcastService.getMapDev().replace(id, book);
    }
    
    public Book remove(Long id) {
        logger.info("remove book by id: " + id);
        return hazelcastService.getMapDev().remove(id);
    }

}