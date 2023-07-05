package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findDistilleryByRegion(String region);

    Distillery findDistilleryById(Long id);
}
