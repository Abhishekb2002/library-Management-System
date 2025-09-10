package com.example.library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library_Management_System.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
