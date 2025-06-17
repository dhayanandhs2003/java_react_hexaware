package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email); // Optional helper
}
