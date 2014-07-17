package com.noveogroup.model;

public class TreeElem implements TreeElement {
    private int id;

    public TreeElem(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
