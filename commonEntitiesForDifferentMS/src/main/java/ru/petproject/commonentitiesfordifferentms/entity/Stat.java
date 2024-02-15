package ru.petproject.commonentitiesfordifferentms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "stat", schema = "task_schema", catalog = "tasks_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "completed_total", updatable = false)// updatable = false означает, что значения задаются в триггере БД
    private long completedTotal;

    @Column(name = "uncompleted_total", updatable = false)
    private long uncompletedTotal;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    @Column(name = "user_id")
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return id == stat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
