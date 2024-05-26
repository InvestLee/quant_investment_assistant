package org.quant_invest.db.repository;

import org.quant_invest.db.entity.FsEntity;
import org.quant_invest.db.entity.FsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FsRepository extends JpaRepository<FsEntity, FsId> {

    @Query(value = "SELECT * FROM global_fs"
            + "where 1=1"
            + "and ticker = :ticker"
            + "and date = ("
            + "select max(date) from global_fs where ticker = :ticker"
            + "and account = 'BasicEPS'"
            + "and value is not null"
            + ")"
            , nativeQuery = true)
    List<FsEntity> searchRecentFs(String ticker);
}
