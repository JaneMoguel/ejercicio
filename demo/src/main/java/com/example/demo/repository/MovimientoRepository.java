package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Movimiento;


@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}

