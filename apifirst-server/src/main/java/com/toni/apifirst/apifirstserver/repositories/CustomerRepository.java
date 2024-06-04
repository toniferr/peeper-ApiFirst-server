package com.toni.apifirst.apifirstserver.repositories;

import com.toni.apifirst.apifirstserver.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
