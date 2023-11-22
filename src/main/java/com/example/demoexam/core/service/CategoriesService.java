package com.example.demoexam.core.service;

import com.example.demoexam.core.exceptions.general.NotFoundException;
import com.example.demoexam.core.model.Categories;
import com.example.demoexam.core.repository.CategoriesRepository;
import com.example.demoexam.rest.dto.CategoriesDTO;
import com.example.demoexam.rest.dto.CategoriesRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {
    private  final CategoriesRepository categoriesRepository;


    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<CategoriesDTO> findAll() {
        return categoriesRepository.findAll().stream()
                .map(CategoriesDTO::new)
                .collect(Collectors.toList());
    }

    public CategoriesDTO findById(String id) {
        Categories categories = categoriesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categories not found"));
        return new CategoriesDTO(categories);
    }

    public CategoriesDTO save(CategoriesRequestDTO requestDTO) {
        Categories categories = requestDTO.toEntity();
        Categories savedPublisher = categoriesRepository.save(categories);
        return new CategoriesDTO(savedPublisher);
    }

    public CategoriesDTO update(String id, CategoriesRequestDTO requestDTO) {
        if (!categoriesRepository.existsById(id)) {
            throw new NotFoundException("Categories not found");
        }

        Categories categories = requestDTO.toEntity();
        categories.setId(id);
        Categories updateCategories = categoriesRepository.save(categories);
        return new CategoriesDTO(updateCategories);
    }

    public void delete(String id) {
        if (!categoriesRepository.existsById(id)) {
            throw new NotFoundException("Categories not found");
        }
        categoriesRepository.deleteById(id);
    }
}
