package com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.MealJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MealJpaRepository extends JpaRepository<MealJpa, UUID>, JpaSpecificationExecutor<MealJpa> {



}