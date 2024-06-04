package com.toni.apifirst.apifirstserver.repositories;

import com.toni.apifirst.apifirstserver.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ImageRepository extends JpaRepository<Image, UUID> {
}
