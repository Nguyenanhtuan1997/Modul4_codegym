package com.service;

import com.model.Product;

public interface IProductService extends  IService<Product>{
    void save(Product product, int idCategory);
}
