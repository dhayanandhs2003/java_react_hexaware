package com.payroll.backend.repository;

import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

//    // For login
//    Users findByEmail(String email);
//
    // Optional: Search by user name
	Optional<Users> findByUserName(String username); // ✅ CORRECT

//
//    // Optional: List users by role (e.g., only "employee")
//    List<Users> findByRole(UserRole role);
}

