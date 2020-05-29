package com.algaworks.folhapagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.folhapagamento.model.Funcionario;

public class ConsultaMain {

	public static void main(String[] string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FolhaPagamentoPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// busca o funcionário de código 1
		Funcionario funcionario1 = entityManager.find(Funcionario.class, 1);

		// busca o funcionário de código 2
		Funcionario funcionario2 = entityManager.find(Funcionario.class, 2);

		// obtém o nome do departamento associado aos funcionários
		System.out.printf("Funcionário %s está no departamento %s%n", 
				funcionario1.getNome(), funcionario1.getDepartamento().getNome());
		
		System.out.printf("Funcionário %s está no departamento %s%n", 
				funcionario2.getNome(), funcionario2.getDepartamento().getNome());

		entityManager.close();
		entityManagerFactory.close();
	}

}