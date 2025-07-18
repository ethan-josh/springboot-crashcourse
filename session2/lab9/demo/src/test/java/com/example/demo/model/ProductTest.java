package com.example.demo.model;

import com.example.demo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product1,product2,product3;
    @BeforeEach
    void setUp(){
        product1 = new Product("Laptop", 10000); //Product without ID
        product2 = new Product((long)1, "Phone", 900); //Product with ID
        product3 = new Product((long) 1, "Phone", 900); // test with Hash
    }

    @Test
    void testConstructorWithoutId() {
        assertNull(product1.getId());
        assertEquals("Laptop", product1.getName());
        assertEquals(10000, product1.getPrice());
    }

    @Test
    void testConstructorWithId() {
        assertEquals(1, product2.getId());
        assertEquals("Phone", product2.getName());
        assertEquals(900, product2.getPrice());
    }

    @Test
    void testSetters() {
        product1.setId((long)2);
        product1.setName("MSI");
        product1.setPrice(50000);

        assertEquals(2, product1.getId());
        assertEquals("MSI", product1.getName());
        assertEquals(50000, product1.getPrice());
    }

    @Test
    void testToString() {
        String expected = "Product{id=1, name='Phone', price=900.0}";
        assertEquals(expected, product2.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        assertTrue(product2.equals(product3));
        assertEquals(product2.hashCode(), product3.hashCode());
        assertEquals(1L,1);
    }
}