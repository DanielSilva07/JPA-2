package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Acessorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessoriosDao implements IAcessoriosDao{
    @Override
    public Acessorios cadastrar(Acessorios acessorios) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorios);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorios;
    }
    @Override
    public void excluir(Acessorios acessorios) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        acessorios = entityManager.merge(acessorios);
        entityManager.remove(acessorios);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
