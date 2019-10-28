package com.edu.exception;

public class MyException extends Exception {
    public MyException(int id,String mrg) {
        super(mrg);
    }
}
