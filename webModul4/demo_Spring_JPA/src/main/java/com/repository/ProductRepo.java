package com.repository;

import com.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findAllByCategoryId(int id);

    // truy vấn tìm kiếm tên theo HQL
    @Query(value = "select p from Product p where p.name like concat('%',:name,'%')")
    List<Product> getAllByNameHQL(@Param("name") String name);

    // Truy ấn tìm kiếm tên theo SQL thuần
    @Query(nativeQuery = true, value = "select * from product  where name like concat('%',:name,'%')")
    List<Product> getAllByNameSQL(@Param("name") String name);

}
