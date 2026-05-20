package com.gagan.usertaskmanagementsystem.service;

import com.gagan.usertaskmanagementsystem.entity.Task;
import com.gagan.usertaskmanagementsystem.entity.User;
import com.gagan.usertaskmanagementsystem.repository.TaskRepository;
import com.gagan.usertaskmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task addTask(String title, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Task task = new Task();
        task.setTitle(title);
        task.setStatus("PENDING");
        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        return taskRepository.findByUserId(userId);
    }
}