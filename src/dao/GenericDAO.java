package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

public abstract class GenericDAO<T extends Serializable> {

    private Class<T> aClass;

    protected GenericDAO(Class<T> aClass) {
        this.aClass = aClass;
    }

    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }

    public Long count() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select count(c) from " + aClass.getSimpleName() + " c");

        Long count = (Long) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return count;
    }

    public T findOne(String jpql, Object... params) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        T entidade = (T) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();
        return entidade;
    }

    public List<T> find(String jpql, Object... params) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        List<T> entidades = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return entidades;
    }

    public T findById(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        T entidade = entityManager.find(aClass, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return entidade;
    }

    public List<T> findAll() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("from " + aClass.getSimpleName());
        List<T> entidades = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return entidades;
    }

    public void save(T entidade) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updade(T entidade) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.getReference(aClass, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
