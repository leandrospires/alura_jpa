package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta conta1 = em.find(Conta.class, 1L);
	
		System.out.println("Titular: " + conta1.getTitular());
		
		em.getTransaction().begin();
		
		conta1.setSaldo(1000.0);
		
		em.getTransaction().commit();
}
}
