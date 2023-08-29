package com.service.impl;

import com.model.Category;
import com.model.Product;
import com.repository.ICategoryRepo;
import com.repository.ProductRepo;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public void save(Product product, int idCategory) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        } else {
            return new Product();
        }
    }
}
