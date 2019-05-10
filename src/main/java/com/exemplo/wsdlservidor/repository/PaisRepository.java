package com.exemplo.wsdlservidor.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.exemplo.wsdlservidor.assets.Moeda;
import com.exemplo.wsdlservidor.assets.Pais;

@Component
public class PaisRepository {

	private static final Map<String, Pais> paises = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Pais brasil = new Pais();
		brasil.setNome("Brasil");
		brasil.setCapital("Brasilia");
		brasil.setMoeda(Moeda.BRL);
		brasil.setPopulacao(209300000);
		
		Pais uk = new Pais();
		uk.setNome("Reino Unido");
		uk.setCapital("Londres");
		uk.setMoeda(Moeda.GBP);
		uk.setPopulacao(6370500);
		
		paises.put(brasil.getNome(), brasil);
		paises.put(uk.getNome(), uk);
	}
	
	public Pais buscarPorPais(String nome) {
		Assert.notNull(nome, "O país não pode ser nulo");
		return paises.get(nome);
	}
}
