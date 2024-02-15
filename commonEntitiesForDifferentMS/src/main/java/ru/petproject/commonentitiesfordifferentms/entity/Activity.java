package ru.petproject.commonentitiesfordifferentms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

import java.util.Objects;

@Entity
@Table(name = "activity", schema = "task_schema", catalog = "tasks_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", updatable = false)
    private String uuid;

    @Column(name = "activated")
    @Convert(converter = NumericBooleanConverter.class)//автоматом конвертит числа в true\false
    private boolean activated;

    /* Монолитное решение разбил на микросервисы, таблицы с юзерами находятся в иной БД, доступа тут не получить
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; */

    @Column(name = "user_id")
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(id, activity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
