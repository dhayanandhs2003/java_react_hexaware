package com.payroll.backend.service.impl;

import com.payroll.backend.dto.UserDTO;
import com.payroll.backend.dto.request.UsersRequestDTO;
import com.payroll.backend.entity.Users;
import com.payroll.backend.exception.ResourceNotFoundException;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Convert Entity to DTO
    private UserDTO toDTO(Users user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    // Convert DTO to Entity
    private Users toEntity(UsersRequestDTO dto) {
        Users user = new Users();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return usersRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
        return toDTO(user);
    }

    @Override
    public UserDTO createUser(UsersRequestDTO requestDTO) {
        Users user = toEntity(requestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users savedUser = usersRepository.save(user);
        return toDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long userId, UsersRequestDTO requestDTO) {
        Users existingUser = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        // 🚫 Prevent editing SUPER_ADMIN
        if ("SUPER_ADMIN".equals(existingUser.getRole())) {
            throw new RuntimeException("Cannot edit SUPER_ADMIN details");
        }

        existingUser.setUserName(requestDTO.getUserName());
        existingUser.setEmail(requestDTO.getEmail());
        existingUser.setRole(requestDTO.getRole());

        if (requestDTO.getPassword() != null && !requestDTO.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        }

        Users updated = usersRepository.save(existingUser);
        return toDTO(updated);
    }


    @Override
    public void deleteUser(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        // 🚫 Prevent deletion of SUPER_ADMIN
        if ("SUPER_ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Cannot delete SUPER_ADMIN");
        }

        usersRepository.deleteById(userId);
    }

}
