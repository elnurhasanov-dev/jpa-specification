package atl.classroom.task.crud.model.response;

import atl.classroom.task.crud.dao.entity.CardEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAllInfosResponse {
    public Long id;
    public String firstname;
    public String lastname;
    public String birthplace;
    public LocalDate birth_year;
    public Boolean isActive;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
//    @JsonBackReference
    public List<CardEntity> cards;
}
