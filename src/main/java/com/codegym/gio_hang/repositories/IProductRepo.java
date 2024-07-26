package com.codegym.gio_hang.repositories;

import com.codegym.gio_hang.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
}
