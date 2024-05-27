package org.quant_invest.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "global_fs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(FsId.class)
public class FsEntity{

    @Id
    @Column(length = 20, nullable = false)
    private String ticker;

    @Id
    private LocalDate date;

    @Id
    @Column(length = 100, nullable = false)
    private String account;

    @Id
    @Column(length = 1, nullable = false)
    private String freq;

    private Double value;
}
