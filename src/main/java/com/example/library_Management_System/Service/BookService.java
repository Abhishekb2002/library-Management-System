package com.example.library_Management_System.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_Management_System.Entity.Book;
import com.example.library_Management_System.Repository.BookRepo;

@Service
public class BookService {

  @Autowired
  private BookRepo bookRepo;

  private static List<Book> list = new ArrayList<>();

  static {
    list.add(new Book(1L, "pytho", "Nitin L"));
    list.add(new Book(2L, "c++", "Abhishek R B"));
    list.add(new Book(3L, "MArathi", "Ganesh A"));
  }

  // get all books
  public List<Book> getAllBooks() {
    return list;
  }

  // get single book by id
  public Book getBookById(Long id) {
    Book book = null;
    book = list.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    return book;

  }

  // if id is not found use try catch block to handle the exception

  // adding tne new book
  public Book addBook(Book b) {
    list.add(b);
    return b;
  }

  // delete book by id
  public void deleteBook(Long id) {
    list = list.stream().filter(book -> !book.getId().equals(id)).toList();
  }

  // delete all books
  public void deleteAllBooks() {

    list = list.stream().filter(book -> book.getId() == -1).toList();
    // list.clear();
  }

  // update book by id
  public void updateBook(Long id, Book book) {
    list = list.stream().map(b -> {
      if (b.getId().equals(id)) {
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
      }
      return b;
    }).toList();
  }
}
