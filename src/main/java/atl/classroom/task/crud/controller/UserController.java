package atl.classroom.task.crud.controller;

import atl.classroom.task.crud.model.criteria.PageCriteria;
import atl.classroom.task.crud.model.criteria.UserCriteria;
import atl.classroom.task.crud.model.request.CreateUserRequest;
import atl.classroom.task.crud.model.request.UpdateUserRequest;
import atl.classroom.task.crud.model.response.UserResponse;
import atl.classroom.task.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(userService.getUserById(id));
    }

    @PostMapping("/search")
    public ResponseEntity<List<UserResponse>> findUserByCriteria(PageCriteria pageCriteria, UserCriteria userCriteria) {
        return ResponseEntity.status(OK).body(userService.findUserByCriteria(pageCriteria, userCriteria));
    }

    @PostMapping
    public ResponseEntity<Void> createCard(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCard(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        userService.updateUser(id, request);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
