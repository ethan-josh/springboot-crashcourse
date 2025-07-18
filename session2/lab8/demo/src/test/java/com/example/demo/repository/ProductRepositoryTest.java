package com.example.demo.repository;

import com.example.demo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void findAllProducts() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void findByExistingId() {
        Optional<Product> productOpt = productRepository.findById(1L);
        assertTrue(productOpt.isPresent());
        assertEquals("Laptop", productOpt.get().getName());
    }

    @Test
    void findByNonexistentId() {
        Optional<Product> productOpt = productRepository.findById(9L);
        assertTrue(productOpt.isEmpty());
    }

    @Test
    void saveNewProduct() {
        Product newProduct = new Product(null, "Tablet", 400.25);
        Product savedProduct = productRepository.save(newProduct);

        assertEquals(4, savedProduct.getId());
        assertEquals("Tablet", savedProduct.getName());
        assertEquals(400.25, savedProduct.getPrice());
        assertEquals(4, productRepository.findAll().size());
    }

    @Test
    void saveExistingProduct() {
        Optional<Product> productOpt = productRepository.findById(2L);
        assertTrue(productOpt.isPresent());

        Product existingProduct = productOpt.get();
        existingProduct.setName("Mouse");
        existingProduct.setPrice(300.11);

        Product updatedProduct = productRepository.save(existingProduct);

        assertEquals("Mouse", updatedProduct.getName());
        assertEquals(300.11, updatedProduct.getPrice());
    }

    @Test
    void saveWithInvalidId() {
        Product invalidProduct = new Product(9L, "Switch 2", 10000.00);
        int initialSize = productRepository.findAll().size();

        Product result = productRepository.save(invalidProduct);

        assertEquals(invalidProduct, result);
        assertEquals(initialSize, productRepository.findAll().size());
    }
}
