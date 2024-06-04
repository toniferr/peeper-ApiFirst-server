package com.toni.apifirst.apifirstserver.repositories;

import com.toni.apifirst.apifirstserver.domain.Customer;
import com.toni.apifirst.apifirstserver.domain.Order;
import com.toni.apifirst.apifirstserver.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByCustomer(Customer customer);

    List<Order> findAllByOrderLines_Product(Product product);
}
