package com.boot.basic.controller;

import com.boot.basic.data.dto.ProductDTO;
import com.boot.basic.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){
        long startTime = System.currentTimeMillis();

        LOGGER.info("[ProductController] Response :: productID = {}, testLog = {}, Response Time = {}ms",
                productId,"helloLog", (System.currentTimeMillis() - startTime));
        return productService.getProduct(productId);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId, productName, productPrice, productStock);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/product/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){ return null;}
}
