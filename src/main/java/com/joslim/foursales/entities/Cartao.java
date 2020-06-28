package com.joslim.foursales.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long idCartao;
	private String numeroCartao;
	private double limiteCartao;
	
	@Enumerated(EnumType.STRING)
	private TipoCartao tipoCartao;
	
	@ManyToOne
	@JsonIgnore
	private Candidato candidato;
	

	public Cartao(Long idCartao, String numeroCartao, double limiteCartao, TipoCartao tipoCartao, Candidato candidato) {
		super();
		this.idCartao = idCartao;
		this.numeroCartao = numeroCartao;
		this.limiteCartao = limiteCartao;
		this.tipoCartao = tipoCartao;
		this.candidato = candidato;
	}


	public Cartao() {
		
	}



	public Long getIdCartao() {
		return idCartao;
	}


	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}


	public String getNumeroCartao() {
		return numeroCartao;
	}


	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}


	public double getLimiteCartao() {
		return limiteCartao;
	}


	public void setLimiteCartao(double limiteCartao) {
		this.limiteCartao = limiteCartao;
	}


	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}


	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}


	public Candidato getCandidato() {
		return candidato;
	}


	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCartao == null) ? 0 : idCartao.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (idCartao == null) {
			if (other.idCartao != null)
				return false;
		} else if (!idCartao.equals(other.idCartao))
			return false;
		return true;
	}
	
	
	

}
