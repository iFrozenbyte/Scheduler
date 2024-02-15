package ru.petproject.schedulertasks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.petproject.commonentitiesfordifferentms.entity.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
    Stat findByUserId(Long userId); // всегда получаем только 1 объект, т.к. 1 пользователь содержит только 1 строку статистики (связь "один к одному")
}