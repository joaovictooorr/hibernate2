package br.com.projeto.DAO;

import br.com.projeto.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProdutoDAO implements IProdutoDAO{
    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return produto;
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public void excluir(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public Produto alterar(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Produto> list =
                entityManager.createQuery("SELECT c FROM Produto c", Produto.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return list;
    }


}
