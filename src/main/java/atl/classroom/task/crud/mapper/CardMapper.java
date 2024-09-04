package atl.classroom.task.crud.mapper;

import atl.classroom.task.crud.dao.entity.CardEntity;
import atl.classroom.task.crud.model.request.CreateCardRequest;
import atl.classroom.task.crud.model.request.UpdateCardRequest;
import atl.classroom.task.crud.model.response.CardResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CardMapper {
    CardMapper CARD_MAPPER = Mappers.getMapper(CardMapper.class);

    CardResponse buildCardResponse(CardEntity cardEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", defaultValue = "ACTIVE")
    CardEntity buildCardEntity(CreateCardRequest cardResponse);

    @Mapping(target = "id", ignore = true)
    void updateCardEntity(@MappingTarget CardEntity entity, UpdateCardRequest request);
}
