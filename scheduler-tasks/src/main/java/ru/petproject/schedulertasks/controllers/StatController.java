package ru.petproject.schedulertasks.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.petproject.commonentitiesfordifferentms.entity.Stat;
import ru.petproject.schedulertasks.service.StatService;

@RestController
public class StatController {
    private final StatService statService;

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired для переменной класса, т.к. "Field injection is not recommended "
    public StatController(StatService statService) {
        this.statService = statService;
    }

    // для статистики всегда получаем только одну строку с id=1 (согласно таблице БД)
    @PostMapping("/stat")
    public ResponseEntity<Stat> findByUserId(@RequestBody Long userId) {

        // можно не использовать ResponseEntity, а просто вернуть коллекцию, код все равно будет 200 ОК
        return ResponseEntity.ok(statService.findStat(userId));
    }
}