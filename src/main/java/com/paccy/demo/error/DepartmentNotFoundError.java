package com.paccy.demo.error;

public class DepartmentNotFoundError extends  Exception{
    public DepartmentNotFoundError() {
        super();
    }

    protected DepartmentNotFoundError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DepartmentNotFoundError(String message) {
        super(message);
    }

    public DepartmentNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundError(Throwable cause) {
        super(cause);
    }
}
