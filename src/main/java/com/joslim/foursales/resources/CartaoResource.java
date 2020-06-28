package com.joslim.foursales.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joslim.foursales.entities.Cartao;
import com.joslim.foursales.services.CartaoService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoResource {
	
	@Autowired
	private CartaoService service;

	@GetMapping
	public ResponseEntity<List<Cartao>> findAll() {
		List<Cartao> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{idCartao}")
	public ResponseEntity<Cartao> findById(@PathVariable Long idCartao) {
		Cartao obj = service.findById(idCartao);
		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping
	public ResponseEntity<Cartao> insert(@RequestBody Cartao obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCartao}").buildAndExpand(obj.getIdCartao()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{idCartao}")
	public ResponseEntity<Void> delete (@PathVariable Long idCartao){
		service.delete(idCartao);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{idCartao}")
	public ResponseEntity<Cartao> update(@PathVariable Long idCartao,@RequestBody Cartao obj ) {
		obj = service.update(idCartao, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
