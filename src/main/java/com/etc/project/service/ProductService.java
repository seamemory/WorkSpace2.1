package com.etc.project.service;

import com.etc.project.domain.Product;

import java.util.List;

public interface ProductService {

    // 根据商品名称进行模糊查询
    List<Product> findProductByNameLike(String name);
}
