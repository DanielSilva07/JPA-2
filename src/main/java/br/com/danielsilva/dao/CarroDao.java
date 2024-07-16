package br.com.danielsilva.dao;
import br.com.danielsilva.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarroDao implements ICarroDao{
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }

    @Override
    public void excluir(Carro carro) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
    @Override
    public Carro buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Carro carro = entityManager.find(Carro.class ,id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return carro;
    }
    @Override
    public List<Carro> buscarTodos() {
        return List.of();
    }
}
