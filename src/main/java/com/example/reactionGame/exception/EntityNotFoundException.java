package com.example.reactionGame.exception;

public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
