package abc.mortalliao.server.web.handler;

import abc.mortalliao.server.common.CommonResponse;
import abc.mortalliao.server.common.exception.ParamValidationException;
import abc.mortalliao.server.common.exception.PermissionDeniedException;
import abc.mortalliao.server.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom Exception handler
 */
@Slf4j
@ControllerAdvice(annotations = ResponseBody.class)
public class CustomExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResponse commonExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[SystemException]Exception:", e);
        return commonResponse.fail("System Error, please try again later! Message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(value = ServiceException.class)
    public CommonResponse serviceExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ServiceException]Exception:", e);
        return commonResponse.fail("ServiceException, message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = PermissionDeniedException.class)
    public CommonResponse permissionDeniedExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[PermissionDeniedException]Exception:", e);
        return commonResponse.fail("Permission Denied!");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ParamValidationException.class,
            ServletRequestBindingException.class})
    public CommonResponse paramValidationExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ParamValidationException]Exception:", e);
        return commonResponse.fail("Parameter validation failure! Message:" + e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public CommonResponse resourceNotFoundExceptionHandle(Exception e) {
        CommonResponse commonResponse = CommonResponse.createCommonResponse();
        log.error("[ResourceNotFoundException]Exception:", e);
        return commonResponse.fail("Resource not found! Message:" + e.getMessage());
    }
}
