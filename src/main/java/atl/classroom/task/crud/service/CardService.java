package atl.classroom.task.crud.service;

import atl.classroom.task.crud.model.request.CreateCardRequest;
import atl.classroom.task.crud.model.request.UpdateCardRequest;
import atl.classroom.task.crud.model.response.CardResponse;

public interface CardService {

    void createCard(CreateCardRequest request);

    void deleteCard(Long id);

    void updateCard(Long id, UpdateCardRequest request);

    CardResponse getCardById(Long id);
}
