package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Carro;
import br.com.danielsilva.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaDao  implements IMarcaDao{

    @Override
    public Marca cadastrar(Marca marca) {

        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca ;
    }

    @Override
    public void excluir(Marca marca) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
    @Override
    public Marca buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("JPA-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Marca marca = entityManager.find(Marca.class ,id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return marca;
    }


}
