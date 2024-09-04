package atl.classroom.task.crud.dao.repository;

import atl.classroom.task.crud.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    @EntityGraph(attributePaths = {"cards"}, type = EntityGraph.EntityGraphType.FETCH)
    List<UserEntity> findAll();

    @Query("SELECT d FROM UserEntity d JOIN FETCH d.cards")
    List<UserEntity> findAllUsersInfo();

    @Query(value = "SELECT u.* FROM users u JOIN cards c ON u.id = c.user_id", nativeQuery = true)
    List<UserEntity> findAllUsersInfoWithNativeQuery();
}
