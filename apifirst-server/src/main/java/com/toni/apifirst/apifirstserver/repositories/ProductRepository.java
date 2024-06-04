package com.toni.apifirst.apifirstserver.repositories;

import com.toni.apifirst.apifirstserver.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, UUID> {
}
