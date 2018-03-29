package com.exception;

import com.suresh.constants.ExceptionConstants;

public class CustomException extends RuntimeException
{
	 private static final long serialVersionUID = 1L;
     
	    private int exceptionType = ExceptionConstants.UNKNOWN_EXCEPTION;
	    private String msg = ExceptionConstants.getMessage(ExceptionConstants.UNKNOWN_EXCEPTION);
	    
	    /**
	     * @param msg
	     */
	    public CustomException(int param) {
	        super(ExceptionConstants.getMessage(param));
	        msg = ExceptionConstants.getMessage(param);
	        this.exceptionType = param;
	    }
	    
	    public CustomException(int param, String errorMsg) {
	        super (ExceptionConstants.getMessage(param) + errorMsg);
	        msg = errorMsg;
	        this.exceptionType = param;
	    }
	    
	    
	    public CustomException(int param, Throwable root) {
	        super (ExceptionConstants.getMessage(param), root);
	        msg = ExceptionConstants.getMessage(param);
	        this.exceptionType = param;
	    }
	              
	    /**
	     * Returns the exception type
	     * @return
	     */
	    public int getExceptionType() {
	        return this.exceptionType;
	    }
	    
	    public String getMessage() {
	        return msg;
	    }
	
}
