package atl.classroom.task.crud.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;

    public String firstname;

    public String lastname;

    public String birthplace;

    public LocalDate birth_year;

    public Boolean isActive;

    @CreationTimestamp
    public LocalDateTime created_at;

    @UpdateTimestamp
    public LocalDateTime updated_at;
}
