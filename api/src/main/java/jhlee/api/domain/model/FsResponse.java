package jhlee.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quant_invest.db.entity.FsId;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FsResponse {

    private String ticker;

    private LocalDate date;

    private String account;

    private String freq;

    private Double value;
}
