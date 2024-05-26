package org.quant_invest.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "global_fs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FsEntity{

    @EmbeddedId
    private FsId fsId;

    private double value;
}
