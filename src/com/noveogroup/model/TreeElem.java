package com.noveogroup.model;

import java.io.Serializable;

public class TreeElem implements TreeElement , Serializable {
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
