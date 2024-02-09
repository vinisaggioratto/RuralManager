package com.vgs.rm.repository;

import com.vgs.rm.entity.RaceAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceAnimalRepository extends JpaRepository<RaceAnimal, Long> {
}
