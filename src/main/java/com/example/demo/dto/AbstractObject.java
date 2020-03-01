package com.example.demo.dto;

public abstract class AbstractObject {

    private String commonValue;

    public AbstractObject() {
    }

    public String getCommonValue() {
        return commonValue;
    }

    public void setCommonValue(String commonValue) {
        this.commonValue = commonValue;
    }

    @Override
    public String toString() {
        return "AbstractObject{" +
                "commonValue='" + commonValue + '\'' +
                '}';
    }
}
