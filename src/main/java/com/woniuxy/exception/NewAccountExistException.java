package com.woniuxy.exception;

public class NewAccountExistException extends RuntimeException{
    public NewAccountExistException(){

    }
    public NewAccountExistException(String msg){
        super(msg);
    }
    public NewAccountExistException(Throwable cause){
        super(cause);
    }
    public NewAccountExistException(String msg, Throwable cause){
        super(msg,cause);
    }
}
