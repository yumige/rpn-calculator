package com.airwallex.rpncalculator.exception;

/**
 * @Author Sangdi
 * @Date 2019/1/14
 */
public class OperationException extends Exception {

    private String operation;
    private String stackInfo;

    public OperationException(String operation, String message){
        super(message);
        this.operation = operation;
    }

    public String getOperation(){
        return this.operation;
    }

    public String getStackInfo() {
        return stackInfo;
    }

    public void setStackInfo(String stackInfo) {
        this.stackInfo = stackInfo;
    }
}
