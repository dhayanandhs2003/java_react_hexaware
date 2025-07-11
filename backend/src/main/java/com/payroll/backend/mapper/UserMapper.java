package com.payroll.backend.mapper;

import com.payroll.backend.dto.UserDTO;
import com.payroll.backend.dto.request.UsersRequestDTO;
import com.payroll.backend.entity.Users;

public class UserMapper {

    // Convert Entity to DTO
    public static UserDTO toDTO(Users user) {
        if (user == null) return null;
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    // Convert Request DTO to Entity
    public static Users toEntity(UsersRequestDTO dto) {
        if (dto == null) return null;
        Users user = new Users();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }

    // Update existing entity from DTO
    public static void updateEntity(Users user, UsersRequestDTO dto) {
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
    }
}

