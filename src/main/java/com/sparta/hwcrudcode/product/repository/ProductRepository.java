package com.sparta.hwcrudcode.product.repository;

import com.sparta.hwcrudcode.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
