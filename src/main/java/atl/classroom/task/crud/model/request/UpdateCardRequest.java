package atl.classroom.task.crud.model.request;

import atl.classroom.task.crud.model.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardRequest {
    private String pan;
    private String cvv;
    private String cardHolder;
    private LocalDate expirationDate;
    private CardStatus status;
}
