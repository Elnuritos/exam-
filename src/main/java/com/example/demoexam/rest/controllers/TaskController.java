package com.example.demoexam.rest.controllers;

import com.example.demoexam.core.exceptions.general.BadRequestException;
import com.example.demoexam.core.exceptions.general.NotFoundException;
import com.example.demoexam.core.model.Task;
import com.example.demoexam.core.service.TaskService;
import com.example.demoexam.rest.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public ResponseEntity<List<TaskDto>> getAllPublishers() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getPublisherById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TaskDto> createPublisher(@RequestBody TaskRequestDto requestDTO) {
        try {
            return new ResponseEntity<>(taskService.save(requestDTO), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updatePublisher(@PathVariable String id, @RequestBody TaskRequestDto requestDTO) {
        try {
            return new ResponseEntity<>(taskService.update(id, requestDTO), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable String id) {
        try {
            taskService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/pagination")
    public PaginationDTO<Task> getTasksWithPagination(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Page<Task> page = taskService.findTasksWithPagination(search, PageRequest.of(offset, limit));
        return new PaginationDTO<>(offset, limit, page.getTotalElements(), page.getContent());
    }
}
