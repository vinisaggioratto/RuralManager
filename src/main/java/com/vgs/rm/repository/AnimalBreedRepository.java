package com.vgs.rm.repository;

import com.vgs.rm.entity.AnimalBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalBreedRepository extends JpaRepository<AnimalBreed, Long> {
}
