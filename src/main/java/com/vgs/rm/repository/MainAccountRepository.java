package com.vgs.rm.repository;

import com.vgs.rm.entity.MainAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainAccountRepository extends JpaRepository<MainAccount, Long> {
}
