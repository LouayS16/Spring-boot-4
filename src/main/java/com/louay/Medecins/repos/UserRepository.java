package com.louay.Medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louay.Medecins.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}