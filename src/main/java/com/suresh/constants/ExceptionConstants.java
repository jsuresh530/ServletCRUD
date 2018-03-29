package com.suresh.constants;

public class ExceptionConstants implements Constants
{
	public static final int UNKNOWN_EXCEPTION = 0;
    public static final int VALIDATION_EXCEPTION = 1;
    public static final int PARSING_EXCEPTION = 2;
    
    public static final String MESSAGE_UNKNOWN_EXCEPTION = "An error occurred due to unknown reason, following are the details: ";
    public static final String MESSAGE_VALIDATION_EXCEPTION = "An error occurred due to Validation error, following are the details: ";
    public static final String MESSAGE_INTERNAL_NETWORK_EXCEPTION = "An internal error occurred due to internal network problems, following are the details: ";
    public static final String MESSAGE_PARSING_EXCEPTION = "An internal error occurred due to parser error, following are the details: ";

    
    //exception messages to be send in API
    public static final String RESPONSE_UNKNOWN_EXCEPTION = "Unknown reason : ";
    public static final String RESPONSE_VALIDATION_EXCEPTION = "Validation error : ";
    public static final String RESPONSE_INTERNAL_NETWORK_EXCEPTION = "Internal network problems : ";
    public static final String RESPONSE_PARSING_EXCEPTION = "Parser error : ";
    
    public static String getMessage(int param) {
        //exception messages
        if (param == 0) {
                 return RESPONSE_UNKNOWN_EXCEPTION;
        }
        else if (param == NUMBER_ONE) {
                 return RESPONSE_VALIDATION_EXCEPTION;
        }
        else if (param == NUMBER_TWO) {
                 return RESPONSE_PARSING_EXCEPTION;
        }
        else if (param == NUMBER_THREE) {
                 return RESPONSE_INTERNAL_NETWORK_EXCEPTION;
        }
        else{
                 return "Unknown Parameter";
        }
        
   }
}
