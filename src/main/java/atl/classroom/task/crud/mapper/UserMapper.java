package atl.classroom.task.crud.mapper;

import atl.classroom.task.crud.dao.entity.UserEntity;
import atl.classroom.task.crud.model.request.CreateUserRequest;
import atl.classroom.task.crud.model.request.UpdateUserRequest;
import atl.classroom.task.crud.model.response.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserResponse buildUserResponse(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", expression = "java(true)")
    UserEntity buildUserEntity(CreateUserRequest userRequest);

    @Mapping(target = "id", ignore = true)
    void updateUserEntity(@MappingTarget UserEntity entity, UpdateUserRequest request);
}
