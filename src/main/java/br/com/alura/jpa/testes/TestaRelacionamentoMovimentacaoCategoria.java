package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Neg�cio");

		Conta conta = new Conta();
		conta.setId(2L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(355.0));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem a RG");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(455.0));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
