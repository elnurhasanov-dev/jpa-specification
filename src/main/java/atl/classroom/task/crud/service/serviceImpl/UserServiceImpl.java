package atl.classroom.task.crud.service.serviceImpl;

import atl.classroom.task.crud.dao.entity.UserEntity;
import atl.classroom.task.crud.dao.repository.UserRepository;
import atl.classroom.task.crud.model.criteria.PageCriteria;
import atl.classroom.task.crud.model.criteria.UserCriteria;
import atl.classroom.task.crud.model.request.CreateUserRequest;
import atl.classroom.task.crud.model.request.UpdateUserRequest;
import atl.classroom.task.crud.model.response.UserResponse;
import atl.classroom.task.crud.service.UserService;
import atl.classroom.task.crud.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static atl.classroom.task.crud.mapper.UserMapper.USER_MAPPER;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public UserResponse getUserById(Long id) {
        var user = fetchUserIfExist(id);
        return USER_MAPPER.buildUserResponse(user);
    }

    @Override
    public List<UserResponse> findUserByCriteria(PageCriteria pageCriteria, UserCriteria userCriteria) {
        var users = userRepository.findAll(new UserSpecification(userCriteria),
                PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount()));

        return users.map(USER_MAPPER::buildUserResponse).toList();
    }

    @Override
    public void createUser(CreateUserRequest request) {
        userRepository.save(USER_MAPPER.buildUserEntity(request));

    }

    @Override
    public void updateUser(Long id, UpdateUserRequest request) {
        var user = fetchUserIfExist(id);
        USER_MAPPER.updateUserEntity(user, request);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        var user = fetchUserIfExist(id);
        user.setIsActive(false);
        userRepository.save(user);
    }

    private UserEntity fetchUserIfExist(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.getUser.error id:{}", id);
                    throw new RuntimeException("USER_NOT_FOUND");
                }
        );
    }
}
