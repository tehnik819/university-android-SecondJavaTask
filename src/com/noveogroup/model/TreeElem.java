package com.noveogroup.model;

public class TreeElem implements TreeElement {
    private int id;

    TreeElem(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
