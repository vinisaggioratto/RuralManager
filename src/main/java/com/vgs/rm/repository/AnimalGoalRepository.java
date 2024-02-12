package com.vgs.rm.repository;

import com.vgs.rm.entity.AnimalGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalGoalRepository extends JpaRepository<AnimalGoal, Long> {
}
