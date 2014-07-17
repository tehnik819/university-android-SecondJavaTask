package com.noveogroup.exception;

public class BinaryTreeException extends Exception {
    public final String key;

    public BinaryTreeException(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Problems with key:" + key;
    }
}
