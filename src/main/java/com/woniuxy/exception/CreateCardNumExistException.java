package com.woniuxy.exception;

public class CreateCardNumExistException extends RuntimeException{
    public CreateCardNumExistException(){

    }
    public CreateCardNumExistException(String msg){
        super(msg);
    }
    public CreateCardNumExistException(Throwable cause){
        super(cause);
    }
    public CreateCardNumExistException(String msg, Throwable cause){
        super(msg,cause);
    }
}
