package com.richkane.styloo.persistence.repository;

import com.richkane.styloo.persistence.model.Cart;
import com.richkane.styloo.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query(value = "SELECT c FROM User u JOIN u.customerDetails cd JOIN Cart c WHERE u.email = :email")
    Optional<Cart> findCartByEmail(@Param("email") String email);
    Long deleteByEmail(String email);
}
