package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}