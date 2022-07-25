package com.scaler.parkinglot.models;

public abstract class BaseModel {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
//    abstract Object toDto();
}
