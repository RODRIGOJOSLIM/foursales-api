package com.joslim.foursales.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joslim.foursales.entities.Cartao;
import com.joslim.foursales.repositories.CartaoRepository;
import com.joslim.foursales.services.exceptions.ResourceNotFoundException;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	
	public List<Cartao> findAll(){
		return repository.findAll();
	}
	
	public Cartao findById (Long idCartao) {
		Optional<Cartao> obj = repository.findById(idCartao);
		return obj.orElseThrow(() -> new ResourceNotFoundException(idCartao));
	}
	
	public Cartao insert (Cartao obj) {
		return repository.save(obj);
		
	}
	
	public void delete (Long idCartao) {
		try {
		repository.deleteById(idCartao);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idCartao);
		} 
	}
	
	public Cartao update(Long idCartao, Cartao obj ) {
		try {
			Cartao entity = repository.getOne(idCartao);
			updateData(entity,obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(idCartao);
		}
	}

	private void updateData(Cartao entity, Cartao obj) {
		entity.setLimiteCartao(obj.getLimiteCartao());;
		entity.setTipoCartao(obj.getTipoCartao());
		
	}


}
