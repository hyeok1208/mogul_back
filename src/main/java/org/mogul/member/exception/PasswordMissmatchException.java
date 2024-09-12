package org.mogul.member.exception;

public class PasswordMissmatchException extends RuntimeException {
    public PasswordMissmatchException() {
        super("비번 틀림요");
    }
}