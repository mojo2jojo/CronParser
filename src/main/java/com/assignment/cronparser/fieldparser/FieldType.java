package com.assignment.cronparser.fieldparser;

public class FieldType {

    private int low;
    private int high;
    private String name;

    public FieldType(int low, int high, String name) {
        this.low = low;
        this.high = high;
        this.name = name;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public String getName() {
        return name;
    }

}
