package com.yg.boardserver.exception;

public class DuplicateIdException extends RuntimeException {

    public DuplicateIdException(String msg) {
        super(msg);
    }

}