package com.vgs.rm.repository;

import com.vgs.rm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.username = :username")
    User findByUsernameFetRoles(@Param("username")String username);
}
