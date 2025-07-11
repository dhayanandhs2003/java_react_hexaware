package com.payroll.backend.service;

import com.payroll.backend.dto.UserDTO;
import com.payroll.backend.dto.request.UsersRequestDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);
    UserDTO createUser(UsersRequestDTO requestDTO);
    UserDTO updateUser(Long userId, UsersRequestDTO requestDTO);
    void deleteUser(Long userId);
}

