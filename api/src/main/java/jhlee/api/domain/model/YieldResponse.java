package jhlee.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YieldResponse {

    private LocalDate date;

    private double t10y2y;

    private double t10y3m;

    private double t10yie;
}
