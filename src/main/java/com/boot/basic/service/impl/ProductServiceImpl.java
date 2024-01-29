package com.boot.basic.service.impl;

import com.boot.basic.data.dto.ProductDTO;
import com.boot.basic.data.entity.ProductEntity;
import com.boot.basic.data.handler.ProductDataHandler;
import com.boot.basic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDTO getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDTO productDTO = new ProductDTO(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock()
        );

        return productDTO;
    }

    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(
                productId,
                productName,
                productPrice,
                productStock
        );

        ProductDTO productDTO = new ProductDTO(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock()
        );

        return productDTO;
    }
}
