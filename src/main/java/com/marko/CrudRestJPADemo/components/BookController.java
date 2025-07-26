package com.marko.CrudRestJPADemo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bookstore")
public class BookController {

    @Autowired
    BookService service;

    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(book));
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBookById(id));
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book newBook) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateBook(id, newBook));
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable int id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
