package com.ibik.toko.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
  List<Product> findByPublished(boolean published);
  List<Product> findByTitleContaining(String title);
}