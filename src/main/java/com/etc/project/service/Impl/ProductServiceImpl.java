package com.etc.project.service.Impl;

import com.etc.project.dao.Impl.ProductDaoImpl;
import com.etc.project.dao.ProductDao;
import com.etc.project.domain.Product;
import com.etc.project.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> findProductByNameLike(String name) {
        List<Product> list = productDao.findProductByNameLike(name);

            return list;
    }
}
