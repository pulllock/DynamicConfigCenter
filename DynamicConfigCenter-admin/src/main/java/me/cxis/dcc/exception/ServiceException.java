package me.cxis.dcc.exception;

import me.cxis.dcc.model.ErrorCode;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7568794831915408895L;

    protected int exceptionCode = -1;

    private ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        this(errorCode, false);
    }

    public ServiceException(int errorCode, String errorMessage) {
        super(String.format("ErrorCode: %d Message: %s", errorCode, errorMessage));
        this.errorCode = null;
        this.exceptionCode = errorCode;
    }

    public ServiceException(ErrorCode errorCode, boolean suppressLogging) {
        this(errorCode, null, suppressLogging);
    }

    public ServiceException(ErrorCode errorCode, String extErrMsg) {
        this(errorCode, extErrMsg, false);
    }

    public ServiceException(ErrorCode errorCode, String extErrMsg, boolean suppressLogging){
        super(String.format("%s %s", errorCode.getMsg(), extErrMsg == null ? "" : extErrMsg));
        this.exceptionCode = errorCode.getCode();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
