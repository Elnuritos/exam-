package com.example.demoexam.core.service;

import com.example.demoexam.core.exceptions.general.NotFoundException;
import com.example.demoexam.core.model.Task;
import com.example.demoexam.core.repository.TaskRepository;
import com.example.demoexam.rest.dto.TaskDto;
import com.example.demoexam.rest.dto.TaskRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> findAll() {
        return taskRepository.findAll().stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
    }

    public TaskDto findById(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        return new TaskDto(task);
    }

    public TaskDto save(TaskRequestDto requestDTO) {
        Task task = requestDTO.toEntity();
        Task savedPublisher = taskRepository.save(task);
        return new TaskDto(savedPublisher);
    }

    public TaskDto update(String id, TaskRequestDto requestDTO) {
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException("Task not found");
        }

        Task task = requestDTO.toEntity();
        task.setId(id);
        Task updatedtask = taskRepository.save(task);
        return new TaskDto(updatedtask);
    }

    public void delete(String id) {
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException("Task not found");
        }
        taskRepository.deleteById(id);
    }
    public List<TaskDto> findAllPaginate() {
        return taskRepository.findAll().stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
    }
    public Page<Task> findTasksWithPagination(String search, Pageable pageable) {
        return taskRepository.findByTitleContainingOrDescriptionContaining(search, search, pageable);
    }
}
