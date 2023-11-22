package com.example.demoexam.core.repository;

import com.example.demoexam.core.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Page<Task> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageable);
}

