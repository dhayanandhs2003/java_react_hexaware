package com.payroll.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.backend.config.NoSecurityTestConfig;
import com.payroll.backend.dto.UserDTO;
import com.payroll.backend.dto.request.UsersRequestDTO;
import com.payroll.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        controllers = UserController.class,
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = { com.payroll.backend.security.JwtAuthenticationFilter.class }
        )
)
@Import(NoSecurityTestConfig.class) // 👈 Import test-specific security override
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAllUsers() throws Exception {
        UserDTO user1 = new UserDTO(1L, "John Doe", "john@example.com");
        UserDTO user2 = new UserDTO(2L, "Jane Smith", "jane@example.com");
        List<UserDTO> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("John Doe")));
    }

    @Test
    void shouldReturnUserById() throws Exception {
        UserDTO user = new UserDTO(1L, "John Doe", "john@example.com");
        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("john@example.com")));
    }

    @Test
    void shouldCreateUser() throws Exception {
        UsersRequestDTO request = new UsersRequestDTO("Alice", "alice@example.com");
        UserDTO created = new UserDTO(3L, "Alice", "alice@example.com");

        when(userService.createUser(Mockito.any(UsersRequestDTO.class))).thenReturn(created);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Alice")));
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UsersRequestDTO update = new UsersRequestDTO("Updated", "updated@example.com");
        UserDTO updated = new UserDTO(1L, "Updated", "updated@example.com");

        when(userService.updateUser(Mockito.eq(1L), Mockito.any(UsersRequestDTO.class))).thenReturn(updated);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated")));
    }

    @Test
    void shouldDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}
