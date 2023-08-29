package com.dao;

import com.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProductDAO {
    @PersistenceContext
    EntityManager entityManager;


    public List<Product> getAll(){
        return entityManager.createQuery("from Product ", Product.class).getResultList();
    }

    public void save(Product product){
        entityManager.persist(product);
    }

    public void edit(Product product){
        entityManager.merge(product);
    }

    public void delete(Product product){

        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }

    public Product findById(int id){
        return entityManager.find(Product.class,id);
    }
}