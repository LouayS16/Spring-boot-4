package com.louay.Medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louay.Medecins.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
