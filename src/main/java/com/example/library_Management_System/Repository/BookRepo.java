package com.example.library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_Management_System.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
