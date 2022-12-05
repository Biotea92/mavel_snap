package com.marvel.snap.exception;

public class InvalidRequest extends SnapException{
    private static final String MESSAGE = "잘못된 요청입니다.";

    public InvalidRequest(String message) {
        super(MESSAGE);
    }

    public InvalidRequest(String fieldName, String message) {
        super(MESSAGE);
        addValidation(fieldName, message);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
