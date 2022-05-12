package com.srkapi.clean.domain.exception;

public class TrainExistException extends RuntimeException{

    public TrainExistException(String msg){
        super(msg);
    }
}
