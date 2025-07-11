package com.example.managetask;

import com.example.managetask.entity.Task;
import com.example.managetask.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ManagetaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testAddTask() throws Exception {
		Task task = new Task();
		task.setId((long) 2);
		task.setTitle("Test Task");
		task.setDescription("Created during unit test");
		task.setDueDate(LocalDate.of(2025, 7, 1));
		task.setPriority(Task.Priority.MEDIUM);
		task.setStatus(Task.Status.PENDING);

		mockMvc.perform(post("/api/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(task)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Test Task"));
	}

	@Test
	void testGetAllTasks() throws Exception {
		mockMvc.perform(get("/api/tasks"))
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateTask() throws Exception {
		// First create a task
		Task task = new Task();
		task.setId((long)3);
		task.setTitle("Old Title");
		task.setDescription("To be updated");
		task.setDueDate(LocalDate.now());
		task.setPriority(Task.Priority.LOW);
		task.setStatus(Task.Status.PENDING);
		Task saved = taskRepository.save(task);

		saved.setTitle("Updated Title");
		saved.setStatus(Task.Status.IN_PROGRESS);

		mockMvc.perform(put("/api/tasks/" + saved.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(saved)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Updated Title"))
				.andExpect(jsonPath("$.status").value("IN_PROGRESS"));
	}

	@Test
	void testDeleteTask() throws Exception {
		// Create a task to delete
		Task task = new Task();
		task.setId((long)3);
		task.setTitle("To Delete");
		task.setDescription("Temporary task");
		task.setDueDate(LocalDate.now());
		task.setPriority(Task.Priority.HIGH);
		task.setStatus(Task.Status.PENDING);
		Task saved = taskRepository.save(task);

		// Delete it
		mockMvc.perform(delete("/api/tasks/" + saved.getId()))
				.andExpect(status().isOk());
	}
}
