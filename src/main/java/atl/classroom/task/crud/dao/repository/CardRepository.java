package atl.classroom.task.crud.dao.repository;

import atl.classroom.task.crud.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
