package com.boot.basic.service;

import com.boot.basic.data.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProduct(String productId);
    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);
}
