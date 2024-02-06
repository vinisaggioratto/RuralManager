package com.vgs.rm.repository;

import com.vgs.rm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    //User findUserByLogin(String login);

    User findUserByLogin(String username);
}
