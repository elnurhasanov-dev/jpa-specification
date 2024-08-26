package atl.classroom.task.crud.utils;


import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Slf4j
public class PredicateUtil {
    private final List<Predicate> predicates = new ArrayList<>();

    public static PredicateUtil builder() {
        return new PredicateUtil();
    }

    public static String applyLikePattern(String key) {
        return "%" + key + "%";
    }

    public <T> PredicateUtil addNullSafety(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public Predicate[] build() {
        return predicates.toArray(new Predicate[0]);
    }
}
