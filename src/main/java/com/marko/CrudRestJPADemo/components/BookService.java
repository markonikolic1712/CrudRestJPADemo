package com.marko.CrudRestJPADemo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    List<Book> findBooksByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    List<Book> findBooksByTitle(String keyword) {
        return repository.findByTitleContaining(keyword);
    }

    List<Book> findBooksByPriceRange(double minPrice, double maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice);
    }

    Book createBook(Book book) {
        return repository.save(book);
    }

    Book getBookById(int id) {
        Optional<Book> optional = repository.findById(id);
        return unwrapBook(optional);
    }

    List<Book> getAllBooks(){
        return repository.findAll();
    }

    Book updateBook(int id, Book newBook) {
        Book book = unwrapBook(repository.findById(id));
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPrice(newBook.getPrice());
        book.setImageUrl(newBook.getImageUrl());
        return repository.save(book);
    }

    void deleteBookById(int id) {
        repository.deleteById(id);
    }

    static Book unwrapBook(Optional<Book> optional){
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException();
        }    }
}
