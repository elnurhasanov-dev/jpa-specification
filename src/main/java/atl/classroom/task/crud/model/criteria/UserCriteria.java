package atl.classroom.task.crud.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria {
    private LocalDate yearFrom;
    private LocalDate yearTo;
    private String birthplace;
    private Boolean isActive;
}
