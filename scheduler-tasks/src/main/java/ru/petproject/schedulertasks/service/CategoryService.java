package ru.petproject.schedulertasks.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.petproject.commonentitiesfordifferentms.entity.Category;
import ru.petproject.schedulertasks.repository.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(Long id) {
        return repository.findByUserIdOrderByTitleAsc(id);
    }

    public Category add(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {
        return repository.save(category);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Category findById(Long id) throws NoSuchElementException {
        return repository.findById(id).get();
    }

    // Поиск категорий пользователя по названию
     public List<Category> findByTitle(String text, Long userId) {
        return repository.findByTitle(text, userId);
    }
}