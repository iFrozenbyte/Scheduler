package ru.petproject.schedulertasks.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petproject.commonentitiesfordifferentms.entity.Category;
import ru.petproject.schedulertasks.searchUtilsForRepos.CategorySearchValues;
import ru.petproject.schedulertasks.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/all")
    public List<Category> findAll(@RequestBody Long userId) {
        return categoryService.findAll(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {

        // Проверка ID (создается автоматом, автоинркмент в БД)
        if (category.getId() != null && category.getId() != 0) {
            return new ResponseEntity("Некорректный параметр: ID должен быть пустым", HttpStatus.NOT_ACCEPTABLE);
        }

        // Проверка title
        if (category.getTitle() == null || category.getTitle().trim().isEmpty()) {
            return new ResponseEntity("Не заполнен параметр title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryService.add(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category) {

        // Проверка ID (создается автоматом, автоинркмент в БД)
        if (category.getId() == null || category.getId() == 0) {
            return new ResponseEntity("Некорректный параметр: ID должен быть пустым", HttpStatus.NOT_ACCEPTABLE);
        }

        // Проверка title
        if (category.getTitle() == null || category.getTitle().trim().isEmpty()) {
            return new ResponseEntity("Не заполнен параметр title", HttpStatus.NOT_ACCEPTABLE);
        }

        // метод save работает на сохранение и на апдейт объектов
        categoryService.update(category);

        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        try {
            // проверяем – существует ли по данному id элемент (если нет – выбросится ошибка)
            Category category = categoryService.findById(id);
            // вызываем соответствующий метод из repository (будет выполнена, если не случится ошибка)
            categoryService.delete(id);
        } catch (NoSuchElementException e) {
            // отработает в случае, когда по данному id не будет найдено ничего
            e.printStackTrace();
            return new ResponseEntity("id " + id + " has not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues) {
        // проверка на обязательные параметры
        if (categorySearchValues.getUserId() == null || categorySearchValues.getUserId() == 0) {
            return new ResponseEntity("missed param: user id", HttpStatus.NOT_ACCEPTABLE);
        }
        // поиск категорий пользователя по названию
        List<Category> list = categoryService.findByTitle(categorySearchValues.getTitle(), categorySearchValues.getUserId());

        return ResponseEntity.ok(list);
    }

    @PostMapping("/id")
    public ResponseEntity<Category> findById(@RequestBody Long id) {
        Category category;
        try {
            category = categoryService.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(category);
    }

}