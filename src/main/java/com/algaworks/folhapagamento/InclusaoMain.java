package com.algaworks.folhapagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.folhapagamento.model.Departamento;
import com.algaworks.folhapagamento.model.Funcionario;

public class InclusaoMain {

	public static void main(String[] string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FolhaPagamentoPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// instanciamos um departamento
		Departamento departamento1 = new Departamento();
		departamento1.setNome("Vendas");

		// instanciamos dois funcionários e atribuímos o departamento
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("João das Couves");
		funcionario1.setDepartamento(departamento1);

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Maria Abadia");
		funcionario2.setDepartamento(departamento1);

		// iniciamos uma transação e persistimos os objetos
		entityManager.getTransaction().begin();

		entityManager.persist(departamento1);
		entityManager.persist(funcionario1);
		entityManager.persist(funcionario2);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
