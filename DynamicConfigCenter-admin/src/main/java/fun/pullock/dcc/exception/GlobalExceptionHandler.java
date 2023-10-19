package fun.pullock.dcc.exception;

import fun.pullock.dcc.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public Result<Void> serviceException(ServiceException exception) {
        Result<Void> result = new Result<>();
        result.setSuccess(false);
        result.setCode(exception.getExceptionCode());
        result.setMsg(exception.getMessage());
        result.setModel(null);
        return result;
    }
}
