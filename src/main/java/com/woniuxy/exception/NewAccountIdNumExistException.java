package com.woniuxy.exception;

public class NewAccountIdNumExistException extends RuntimeException {
    public NewAccountIdNumExistException(){

    }
    public NewAccountIdNumExistException(String msg){
        super(msg);
    }
    public NewAccountIdNumExistException(Throwable cause){
        super(cause);
    }
    public NewAccountIdNumExistException(String msg, Throwable cause){
        super(msg,cause);
    }
}
