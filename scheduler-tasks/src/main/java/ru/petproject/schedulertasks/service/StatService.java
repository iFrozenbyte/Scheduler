package ru.petproject.schedulertasks.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petproject.commonentitiesfordifferentms.entity.Stat;
import ru.petproject.schedulertasks.repository.StatRepository;

@Service
@Transactional
public class StatService {
    private final StatRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(Long userId) {
        return repository.findByUserId(userId);
    }
}