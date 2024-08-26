package atl.classroom.task.crud.service.specification;

import atl.classroom.task.crud.dao.entity.UserEntity;
import atl.classroom.task.crud.model.criteria.UserCriteria;
import atl.classroom.task.crud.utils.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static atl.classroom.task.crud.utils.PredicateUtil.applyLikePattern;

@AllArgsConstructor
public class UserSpecification implements Specification<UserEntity> {
    private UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = PredicateUtil.builder()
                .addNullSafety(userCriteria.getBirthplace(),
                        birthplace -> cb.like(root.get("birthplace"), applyLikePattern(birthplace)))
                .addNullSafety(userCriteria.getIsActive(),
                        isActive -> cb.equal(root.get("isActive"), isActive))
                .addNullSafety(userCriteria.getYearFrom(),
                        yearFrom -> cb.greaterThanOrEqualTo(root.get("birth_year"), yearFrom))
                .addNullSafety(userCriteria.getYearTo(),
                        yearTo -> cb.lessThanOrEqualTo(root.get("birth_year"), yearTo))
                .build();

        return cb.and(predicates);
    }
}
