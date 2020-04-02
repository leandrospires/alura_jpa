package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {

		// Transient
		
		Conta conta = new Conta();
		conta.setTitular("Aldo");
		conta.setAgencia(1001);
		conta.setNumero(1252);
		conta.setSaldo(1250.0);
		
		System.out.println("Id: " + conta.getId());
		System.out.println("Titula: " + conta.getTitular());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		// Transient -> Managed
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		
		
		System.out.println("Id: " + conta.getId());
		System.out.println("Titula: " + conta.getTitular());
		
	}
}
