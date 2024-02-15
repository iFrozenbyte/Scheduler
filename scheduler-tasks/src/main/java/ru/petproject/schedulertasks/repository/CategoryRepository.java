package ru.petproject.schedulertasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.petproject.commonentitiesfordifferentms.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserIdOrderByTitleAsc(Long userId);

    // Поиск значений по названию  для конкретного юзера
    @Query("select c from Category c where " +
            "(:title is null or :title=''" +
            " or lower(c.title) like lower(concat('%', :title, '%')))" +
            "and c.userId=:id " + // фильтрация для конкретного юзера
            "order by c.title asc") // сортировка по названию
    List<Category> findByTitle(@Param("title") String title, @Param("id") Long id); // @Param значения будут подставляться в SQL query (:title)
}