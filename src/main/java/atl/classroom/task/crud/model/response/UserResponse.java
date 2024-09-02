package atl.classroom.task.crud.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    public Long id;
    public String firstname;
    public String lastname;
    public String birthplace;
    public LocalDate birth_year;
    public Boolean isActive;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
}
