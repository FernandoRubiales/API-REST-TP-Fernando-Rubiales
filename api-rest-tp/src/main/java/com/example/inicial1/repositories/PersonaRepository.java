package com.example.inicial1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inicial1.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{ //patron DAO, se comunica con la base de datos y separa la logica del negocio

}
