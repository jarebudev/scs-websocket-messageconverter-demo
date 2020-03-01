package com.example.demo.dto;

public class CustomObject extends AbstractObject {
    private String customValue;
    private String anotherValue;

    public CustomObject() {
        super();
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }

    public String getAnotherValue() {
        return anotherValue;
    }

    public void setAnotherValue(String anotherValue) {
        this.anotherValue = anotherValue;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "customValue='" + customValue + '\'' +
                ", anotherValue='" + anotherValue + '\'' +
                '}';
    }
}
