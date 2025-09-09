package com.example.library_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_Management_System.Entity.Book;
import com.example.library_Management_System.Service.BookService;

@RestController
@RequestMapping("/api")
public class HelloController {

  @Autowired
  private BookService bookService;

  // @GetMapping("/hello")
  // public String hello() {
  // return "Hello, Library Management System!";
  // }

  @GetMapping("/book")
  public Book getSampleBook() {
    Book book = new Book(null, null, null);
    book.setId(1L);
    book.setTitle("Java Programming");
    book.setAuthor("Abhishek Bhosale");
    return book;
  }

  // @GetMapping("/books")
  // public List<Book> getBooks() {
  // return bookService.getAllBooks();
  // }

  // @GetMapping("/book/{id}")
  // public Book getBook(@PathVariable("id") Long id) {
  // return bookService.getBookById(id);
  // }

  // @PostMapping("/book")
  // public Book createBook(@RequestBody Book book) {
  // return bookService.addBook(book);
  // }

  // @DeleteMapping("/book/{id}")
  // public void deleteBook(@PathVariable("id") Long id) {
  // bookService.deleteBook(id);
  // }

  // @DeleteMapping("/books")
  // public void deleteAllBooks() {
  // bookService.deleteAllBooks();
  // }

  // @PutMapping("/book/{id}")
  // public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
  // bookService.updateBook(id, book);
  // }

  // Get all books
  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> list = bookService.getAllBooks();
    if (list.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(list);
  }

  // Get single book by ID
  @GetMapping("/book/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = bookService.getBookById(id);
    if (book == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(book);
  }

  // Get book by ID with try-catch block (optional alternative)
  @GetMapping("/book/try/{id}")
  public ResponseEntity<Book> getBookByIdWithException(@PathVariable Long id) {
    try {
      Book book = bookService.getBookById(id);
      if (book == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.ok(book);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Add a new book
  @PostMapping("/book")
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    try {
      Book savedBook = bookService.addBook(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Delete a book by ID
  @DeleteMapping("/book/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    try {
      bookService.deleteBook(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  // Update a book by ID
  @PutMapping("/book/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
    try {
      this.bookService.updateBook(id, book);
      return ResponseEntity.ok(book);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
