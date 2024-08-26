package atl.classroom.task.crud.service;

import atl.classroom.task.crud.model.criteria.PageCriteria;
import atl.classroom.task.crud.model.criteria.UserCriteria;
import atl.classroom.task.crud.model.request.CreateUserRequest;
import atl.classroom.task.crud.model.request.UpdateUserRequest;
import atl.classroom.task.crud.model.response.UserResponse;

import java.util.List;

public interface UserService {
    void createUser(CreateUserRequest request);

    void deleteUser(Long id);

    void updateUser(Long id, UpdateUserRequest request);

    UserResponse getUserById(Long id);

    List<UserResponse> findUserByCriteria(PageCriteria pageCriteria, UserCriteria userCriteria);
}
