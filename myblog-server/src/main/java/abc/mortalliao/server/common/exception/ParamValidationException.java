package abc.mortalliao.server.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Parameter validation failure exception
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParamValidationException extends SystemException {

    public ParamValidationException(String message) {
        super(message);
    }
}
