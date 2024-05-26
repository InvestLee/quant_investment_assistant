package org.quant_invest.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class FsId implements Serializable {

    @Column(length = 20, nullable = false)
    private String ticker;

    private LocalDate date;

    @Column(length = 100, nullable = false)
    private String account;

    @Column(length = 1, nullable = false)
    private String freq;
}
