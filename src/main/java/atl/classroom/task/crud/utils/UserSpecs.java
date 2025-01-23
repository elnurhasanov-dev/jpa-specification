package atl.classroom.task.crud.utils;

import atl.classroom.task.crud.dao.entity.UserEntity;
import atl.classroom.task.crud.model.criteria.UserCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecs implements Specification<UserEntity> {

    private UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (userCriteria.getIsActive() != null) {
            predicates.add(cb.equal(root.get("isActive"), userCriteria.getIsActive()));
        }

        if (userCriteria.getBirthplace() != null && !userCriteria.getBirthplace().isEmpty()) {
            predicates.add(cb.equal(root.get("birthplace"), userCriteria.getBirthplace()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }

}

//public class UserSpecs {
//    public static Specification<UserEntity> containsBirthplace(String providedBirthplace) {
//        return (root, query, cb) -> cb.like(cb.lower(root.get("birthplace")),
//                "%" + providedBirthplace.toLowerCase() + "%");
//    }
//
//    public static Specification<UserEntity> isActive(Boolean isActive) {
//        return (root, query, cb) -> cb.equal(root.get("isActive"), isActive);
//    }
//
//    public static Specification<UserEntity> ageBetween(int minAge, int maxAge) {
//        return (root, query, cb) -> {
//            LocalDate today = LocalDate.now();
//            return cb.between(root.get("birth_year"),
//                    today.minus(maxAge + 1, ChronoUnit.YEARS).plusDays(1),
//                    today.minus(minAge, ChronoUnit.YEARS));
//        };
//    }

//}
