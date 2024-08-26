package atl.classroom.task.crud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    public String firstname;
    public String lastname;
    public String birthplace;
    public LocalDate birth_year;
}
