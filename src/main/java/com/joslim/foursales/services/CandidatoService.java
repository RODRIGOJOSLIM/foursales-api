package com.joslim.foursales.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joslim.foursales.entities.Candidato;
import com.joslim.foursales.repositories.CandidatoRepository;
import com.joslim.foursales.services.exceptions.ResourceNotFoundException;


@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll(){
		return repository.findAll();
	}
	
	public Candidato findById (Long id) {
		Optional<Candidato> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Candidato insert (Candidato obj) {
		return repository.save(obj);
		
	}
	
	public void delete (Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Candidato update(Long id, Candidato obj ) {
		try {
			Candidato entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Candidato entity, Candidato obj) {
		entity.setNome(obj.getNome());
		entity.setIdade(obj.getIdade());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
	}

}
