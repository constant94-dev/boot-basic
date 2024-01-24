package com.boot.basic.data.dao;

import com.boot.basic.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
}
