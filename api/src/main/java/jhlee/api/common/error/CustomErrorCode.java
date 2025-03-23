package jhlee.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomErrorCode implements ErrorCode{

    private Integer httpStatusCode;
    private Integer errorCode;
    private String description;
}
