package ru.petproject.commonentitiesfordifferentms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "category", schema = "task_schema", catalog = "tasks_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")// По каким полям связаны Fkey
//    private User user;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "completed_count", updatable = false)// updatable = false поле не участвует в сохранении,
    // оно не будет обновляться. Оно автоматически высчитывается в триггерах
    private long completedCount;

    @Column(name = "uncompleted_count", updatable = false)
    private long uncompletedCount;

    @Override
    public String toString() {
        return "title=: " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}