package com.noveogroup.model;

public class FirstChildOfTreeElem extends TreeElem {
    private String description;

    public FirstChildOfTreeElem(int id, String descript) {
        super(id);
        this.description = descript;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Id = " + super.toString() + ";Description = " + description;
    }
}
