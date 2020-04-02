package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class RemoveConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 6L);
	
		System.out.println("Titular: " + conta.getTitular());
		
		em.getTransaction().begin();
		
		em.remove(conta);
		
		em.getTransaction().commit();
}
}
