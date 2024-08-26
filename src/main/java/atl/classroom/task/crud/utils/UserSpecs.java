package atl.classroom.task.crud.utils;

import atl.classroom.task.crud.dao.entity.UserEntity;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserSpecs {
    public static Specification<UserEntity> containsBirthplace(String providedBirthplace) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("birthplace")),
                "%" + providedBirthplace.toLowerCase() + "%");
    }

    public static Specification<UserEntity> isActive(Boolean isActive) {
        return (root, query, cb) -> cb.equal(root.get("isActive"), isActive);
    }

    public static Specification<UserEntity> ageBetween(int minAge, int maxAge) {
        return (root, query, cb) -> {
            LocalDate today = LocalDate.now();
            return cb.between(root.get("birth_year"),
                    today.minus(maxAge + 1, ChronoUnit.YEARS).plusDays(1),
                    today.minus(minAge, ChronoUnit.YEARS));
        };
    }

}
