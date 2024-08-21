package com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.WeekMenuJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeekMenuJpaRepository extends JpaRepository<WeekMenuJpa, UUID>, JpaSpecificationExecutor<WeekMenuJpa> {

    List<WeekMenuJpa> findByUser(UUID user);

}