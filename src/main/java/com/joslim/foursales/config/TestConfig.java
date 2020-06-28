package com.joslim.foursales.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joslim.foursales.entities.Candidato;
import com.joslim.foursales.entities.Cartao;
import com.joslim.foursales.entities.TipoCartao;
import com.joslim.foursales.repositories.CandidatoRepository;
import com.joslim.foursales.repositories.CartaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Candidato cand1 = new Candidato(null, "Maria", 25, "8788874", "Rua da Couves", null);
		Candidato cand2 = new Candidato(null, "Jorge", 57, "4535455", "Rua da Flores", null);
		
		Cartao cartao1 = new Cartao (null, "666", 5000.00,TipoCartao.BLACK , cand1);
		
		Cartao cartao2 = new Cartao (null, "777", 9000.00,TipoCartao.DIAMOND , cand1);
		
		Cartao cartao3 = new Cartao (null, "718", 4000.00,TipoCartao.DIAMOND , cand2);
		
		candidatoRepository.saveAll(Arrays.asList(cand1, cand2));
		cartaoRepository.saveAll(Arrays.asList(cartao1, cartao2, cartao3)); 
	}



	
	
	
}
