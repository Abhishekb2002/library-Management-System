package com.example.library_Management_System;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.library_Management_System.Entity.User;
import com.example.library_Management_System.Repository.UserRepository;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(LibraryManagementSystemApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User();
		user.setName("John Doe");
		user.setCity("New York");
		user.setEmail("bhosaleabhishek@gmail.com");
		user.setStatus("active");

		User user1 = userRepository.save(user);
		System.out.println(user1);

		User user3 = new User();
		user3.setName("John WIck");
		user3.setCity("Pune");
		user3.setEmail("nitinlatapate@gmail.com");
		user3.setStatus("python programing");

		User savedUser = userRepository.save(user3);
		System.out.println(savedUser);

		User user2 = new User();
		user2.setName("John WIck");
		user2.setCity("Pune");
		user2.setEmail("nitinlatapate@gmail.com");
		user2.setStatus("python programing");

		User saved = userRepository.save(user2);
		System.out.println(saved);

		List<User> users = List.of(user, user1, user2, user3);

		// userRepository.saveAll(users);

		Iterable<User> result = userRepository.saveAll(users);

		result.forEach(u -> {
			System.out.println(u);
		});

		// find by id

		// userRepository.findById(1);

		Optional<User> optional = userRepository.findById(1);

		User user4 = optional.get();
		user4.setName("Nitin Latapate");
		user4.setCity("Mumbai");
		user4.setEmail("nitinlatapate@gmail.com");
		user4.setStatus("Java with Spring boot");
		System.out.println(user4);
		User result2 = userRepository.save(user4);
		System.out.println(result2);

		// how to get the data
		// findById(id) return Optional Containig your data

		userRepository.findAll();
		// userRepository.findById();

		Iterable<User> itr = userRepository.findAll();

		// Iterable<User> iterable = itr.iterator(); // ❌ Incorrect: itr.iterator()
		// returns an Iterator, not Iterable

		Iterator<User> iterator = itr.iterator(); // ✅ Correct

		while (iterator.hasNext()) {
			User u = iterator.next();
			System.out.println(u);
		}

		// itr.forEach(new Consumer <User)() {
		// @Override
		// public void accept(User t) {
		// System.out.println(t);
		// }
		// });

		// itr.forEach(user -> System.out.println(user));
		// itr.forEach(user->System.out::println);

		// delete the user by id

		userRepository.deleteAll();
		userRepository.deleteById(2);
		userRepository.delete(user4);

		// userRepository.deleteAll(11);
		System.out.println(" deleted...");

		userRepository.findAll();

		Iterable<User> allUsers = userRepository.findAll();
		allUsers.forEach(u -> System.out.println(u));

	}

}
