package com.example.library_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library_Management_System.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  // select * from user where name = 'John Wick';
  public List<User> findByName(String name);

  public List<User> findByCity(String city);

  @Query("select u from User u")
  public List<User> getAllUsers();

  @Query("select u from User u where u.name = : n")
  public List<User> getUserByName(String name);

  @Query
  public List<User> getUserByName(@Param("n") String name, @Param("c") String city);

}
