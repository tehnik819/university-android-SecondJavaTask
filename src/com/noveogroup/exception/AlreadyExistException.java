package com.noveogroup.exception;

public class AlreadyExistException extends BinaryTreeException {
    public final String value;

    public AlreadyExistException(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element with key: " + key + ";value: " + value + "; already exists";
    }
}
