package ru.petproject.schedulerusers.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.petproject.commonentitiesfordifferentms.entity.User;
import ru.petproject.schedulerusers.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // возвращает 0 либо 1 объект, т.к. email уникален для каждого пользователя
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User add(User user) {
        return repository.save(user); // метод save обновляет или создает новый объект, если его не было
    }

    public User update(User user) {
        return repository.save(user); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteByUserId(Long id) {
        repository.deleteById(id);
    }

    public void deleteByUserEmail(String email) {
        repository.deleteByEmail(email);
    }

    public User findById(Long id) {
        return repository.findById(id).get(); // т.к. возвращается Optional - можно получить объект методом get()
    }

    public Page<User> findByParams(String username, String password, PageRequest paging) {
        return repository.findByParams(username, password, paging);
    }
}
