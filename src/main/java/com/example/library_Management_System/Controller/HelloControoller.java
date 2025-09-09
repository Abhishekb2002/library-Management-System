package com.example.library_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_Management_System.Entity.Book;
import com.example.library_Management_System.Service.BookService;

@Component
@RestController
@RequestMapping("/api")
public class HelloControoller {

  @Autowired
  private BookService bookService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello, Library Management System!";
  }

  @GetMapping("/book")
  public Book getBook() {
    Book book = new Book();
    book.setId(1L);
    book.setTitle("JAva Programming ");
    book.setAuthor("Abhishek Bhosale");
    return book;

  }

  @GetMapping("/books")
  public Book getBooks() {

    return bookService.getAllBooks();

  }

  @GetMapping("/book/{id}")
  public book getBook(@PathVariable("id") Long id) {
    return bookService.getBookById(id);
  }

  @PostMapping("/book")
  public Book createBook(@RequestBody Book book) {
    Book b = this.bookService.addBook(book);
    return bookService.createBook(book);
  }

}
