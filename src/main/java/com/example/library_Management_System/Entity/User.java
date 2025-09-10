package com.example.library_Management_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String city;
  private String email;
  private String status;

  public User() {
    this.city = city;
    this.email = email;
    this.id = id;
    this.name = name;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getEmail() {
    return email;
  }

  public String getStatus() {
    return status;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", status=" + status + "]";
  }

}
