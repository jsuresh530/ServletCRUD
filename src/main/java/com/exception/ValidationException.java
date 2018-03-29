package com.exception;

public class ValidationException extends CustomException
{
	private static final long serialVersionUID = 1L;

    private static int param = 1;

    public ValidationException() {
            super(param);
    }

    public ValidationException(String errorMsg) {
            super(param, errorMsg);
    }

    public ValidationException(Throwable root) {
            super(param, root);
    }
}
