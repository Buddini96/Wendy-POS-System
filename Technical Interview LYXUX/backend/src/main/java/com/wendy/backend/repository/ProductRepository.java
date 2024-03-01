package com.wendy.backend.repository;

import com.wendy.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Buddini
 * Created on 01 Mar, 2024
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
