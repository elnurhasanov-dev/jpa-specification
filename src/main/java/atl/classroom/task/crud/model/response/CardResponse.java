package atl.classroom.task.crud.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private Long id;
    private String pan;
    private String cvv;
    private String cardHolder;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
