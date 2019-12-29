package abc.mortalliao.server.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * System Exception
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends RuntimeException {

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
