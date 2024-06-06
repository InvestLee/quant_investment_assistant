package org.quant_invest.db.repository;

import org.quant_invest.db.entity.YieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface YieldRepository extends JpaRepository<YieldEntity, LocalDate> {

    Optional<YieldEntity> findFirstByT10yieIsNotNullOrderByDateDesc();
    List<YieldEntity> findAllByT10yieIsNotNullOrderByDateAsc();
}
