package atl.classroom.task.crud.service.serviceImpl;

import atl.classroom.task.crud.dao.entity.CardEntity;
import atl.classroom.task.crud.dao.repository.CardRepository;
import atl.classroom.task.crud.model.request.CreateCardRequest;
import atl.classroom.task.crud.model.request.UpdateCardRequest;
import atl.classroom.task.crud.model.response.CardResponse;
import atl.classroom.task.crud.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static atl.classroom.task.crud.mapper.CardMapper.CARD_MAPPER;
import static atl.classroom.task.crud.model.enums.CardStatus.BLOCKED;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public CardResponse getCardById(Long id) {
        var card = fetchCardIfExist(id);
        return CARD_MAPPER.buildCardResponse(card);
    }

    @Override
    public void createCard(CreateCardRequest request) {
        cardRepository.save(CARD_MAPPER.buildCardEntity(request));
    }

    @Override
    public void updateCard(Long id, UpdateCardRequest request) {
        var card = fetchCardIfExist(id);
        CARD_MAPPER.updateCardEntity(card, request);
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        var card = fetchCardIfExist(id);
        card.setStatus(BLOCKED);
        cardRepository.save(card);
    }

    private CardEntity fetchCardIfExist(Long id) {
        return cardRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.getCard.error id:{}", id);
                    throw new RuntimeException("CARD_NOT_FOUND");
                }
        );
    }
}
