package com.noveogroup.exception;

public class NonExistentElementException extends BinaryTreeException {
    public NonExistentElementException(String key) {
        super(key);
    }

    @Override
    public String toString() {
        return "Does not exists element in tree with key:" + key;
    }
}
