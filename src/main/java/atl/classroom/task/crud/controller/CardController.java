package atl.classroom.task.crud.controller;

import atl.classroom.task.crud.model.request.CreateCardRequest;
import atl.classroom.task.crud.model.request.UpdateCardRequest;
import atl.classroom.task.crud.model.response.CardResponse;
import atl.classroom.task.crud.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardResponse> getCardById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(cardService.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCard(@RequestBody CreateCardRequest request) {
        cardService.createCard(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(@PathVariable Long id, @RequestBody UpdateCardRequest request) {
        cardService.updateCard(id, request);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.status(OK).build();
    }
}
