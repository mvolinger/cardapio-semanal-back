package com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.DietTypeJpa;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.IngredientJpa;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IngredientJpaRepository extends JpaRepository<IngredientJpa, UUID>, JpaSpecificationExecutor<IngredientJpa> {

    default List<IngredientJpa> findIngredientsMatchingCriteria(List<String> userDietTrueAttributes) {
        return findAll(buildSpecification(userDietTrueAttributes));
    }

    static Specification<IngredientJpa> buildSpecification(List<String> userDietTrueAttributes) {
        return (root, query, criteriaBuilder) -> {
            Join<IngredientJpa, DietTypeJpa> dietTypeJoin = root.join("dietType");
            List<Predicate> dietTypePredicates = userDietTrueAttributes.stream()
                    .map(attributeName -> criteriaBuilder.isTrue(dietTypeJoin.get(attributeName)))
                    .toList();
            return criteriaBuilder.and(dietTypePredicates.toArray(new Predicate[0]));
        };
    }
}