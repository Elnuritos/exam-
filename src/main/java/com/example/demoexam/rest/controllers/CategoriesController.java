package com.example.demoexam.rest.controllers;

import com.example.demoexam.core.exceptions.general.BadRequestException;
import com.example.demoexam.core.exceptions.general.NotFoundException;
import com.example.demoexam.core.service.CategoriesService;
import com.example.demoexam.core.service.TaskService;
import com.example.demoexam.rest.dto.CategoriesDTO;
import com.example.demoexam.rest.dto.CategoriesRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {


    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    public ResponseEntity<List<CategoriesDTO>> getAllPublishers() {
        return new ResponseEntity<>(categoriesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDTO> getPublisherById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(categoriesService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriesDTO> createPublisher(@RequestBody CategoriesRequestDTO requestDTO) {
        try {
            return new ResponseEntity<>(categoriesService.save(requestDTO), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesDTO> updatePublisher(@PathVariable String id, @RequestBody CategoriesRequestDTO requestDTO) {
        try {
            return new ResponseEntity<>(categoriesService.update(id, requestDTO), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable String id) {
        try {
            categoriesService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
