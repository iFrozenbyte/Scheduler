package ru.petproject.commonentitiesfordifferentms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "task_schema", catalog = "tasks_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean completed;// 1 - true   0 - false

    @Column(name = "task_date")
    private Date taskDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    // задача может иметь только один приоритет (с обратной стороны - один и тот же приоритет может быть использоваться в множестве задач)
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id") // по каким полям связывать (foreign key)
    private Priority priority;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id") // по каким полям связывать (foreign key)
//    private User user; // для какого пользователя задача

    @Column(name = "user_id")
    private Long userId;

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", completed=" + completed +
                ", taskDate=" + taskDate +
                ", id=" + id +
                ", category=" + category +
                ", priority=" + priority +
                ", user id=" + userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
