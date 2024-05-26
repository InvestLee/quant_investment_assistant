package org.quant_invest.db.repository;

import org.quant_invest.db.entity.FearGreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FearGreedRepository extends JpaRepository<FearGreedEntity, LocalDate> {

    Optional<FearGreedEntity> findFirstByOrderByDateDesc();
}
