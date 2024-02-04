package com.assignment.cronparser.specialcharparser;

import java.util.StringJoiner;

import com.assignment.cronparser.fieldparser.FieldType;
import com.assignment.cronparser.utils.Utils;

public class DashParser implements SpecialCharParser{

    @Override
    public String parseChar(String input, FieldType fieldType) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        int length = input.length();
        int index = input.indexOf("-");

        Utils.validation(input.substring(0, index), fieldType);
        Utils.validation(input.substring( index+1, length), fieldType);

        int start = Integer.valueOf(input.substring(0, index));
        int end = Integer.valueOf(input.substring( index+1, length));

        for(int i=start;i<=end;i++) {
            stringJoiner.add(String.valueOf(i));
        }
        return stringJoiner.toString();
    }
    
}
