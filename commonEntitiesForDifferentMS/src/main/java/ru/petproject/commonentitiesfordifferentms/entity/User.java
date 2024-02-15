package ru.petproject.commonentitiesfordifferentms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "my_db")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String password;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToMany(mappedBy = "users")
//    private Set<Role> roles;

    @Override
    public String toString() {
        return "Username='" + username + '\'' +
                "email='" + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
