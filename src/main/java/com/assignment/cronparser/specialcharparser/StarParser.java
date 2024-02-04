package com.assignment.cronparser.specialcharparser;

import java.util.StringJoiner;

import com.assignment.cronparser.fieldparser.FieldType;

public class StarParser implements SpecialCharParser{

    @Override
    public String parseChar(String input, FieldType fieldType) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for(int i=fieldType.getLow();i<=fieldType.getHigh();i++) {
            stringJoiner.add(String.valueOf(i));
        }
        return stringJoiner.toString();
    }
    
}
