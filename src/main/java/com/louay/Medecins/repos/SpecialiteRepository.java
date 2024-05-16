package com.louay.Medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louay.Medecins.entities.Specialite;
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> 
{
}
