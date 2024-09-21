package com.example.inicial1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

@Service //notacion para indicar que es un servicio
public class PersonaService implements BaseService<Persona>{
    
    @Autowired  //spring va a ser el encargado de obtener las dependencias que necesita el servicio
    private PersonaRepository personaRepository;

    // public PersonaService(PersonaRepository personaRepository){ //hace el constructor
       //  this.personaRepository = personaRepository;
    // }

    @Override
    @Transactional //significa que van a hacer transacciones con la base de datos estos metodos
    public List<Persona> findAll() throws Exception {
        
        try {
            List<Persona> entities = personaRepository.findAll(); //obtener todas las personas que tengamos registradas
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entitiyOptional = personaRepository.findById(id); //esto es porque no sabemos si se va a encontrar un objeto persona con ese ID
            return entitiyOptional.get(); //obtiene una entidad si es que la encuentra
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona  = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(personaRepository.existsById(id)){ //colocamos un condicional para saber si existe una persona con ese ID
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
