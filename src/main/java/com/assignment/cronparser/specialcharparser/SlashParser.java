package com.assignment.cronparser.specialcharparser;

import java.util.StringJoiner;

import com.assignment.cronparser.fieldparser.FieldType;
import com.assignment.cronparser.utils.Utils;

public class SlashParser implements SpecialCharParser{

    @Override
    public String parseChar(String input, FieldType fieldType) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        int index = input.indexOf("/");
        int dashIndex = input.indexOf("-");
        int start = fieldType.getLow();
        int end = fieldType.getHigh();

        int step=fieldType.getLow();

        try {
            if (input.charAt(index - 1) == '*') {
                start = fieldType.getLow();
            }
            else if (dashIndex!=-1) {
                if(dashIndex==0 || dashIndex>index || dashIndex==index-1) {
                    throw new RuntimeException("Invalid value for " + fieldType.getName());
                }
                Utils.validation(input.substring(0, dashIndex), fieldType);
                start = Integer.valueOf(input.substring(0, dashIndex));

                Utils.validation(input.substring(dashIndex+1, index), fieldType);
                end = Integer.valueOf(input.substring(dashIndex+1, index));
            }
            else {
                Utils.validation(input.substring(0, index), fieldType);
                start = Integer.valueOf(input.substring(0, index));
            }

            step= Integer.valueOf(input.substring(index + 1, input.length()));
        } catch (Exception e) {
            throw new RuntimeException("Invalid value for " + fieldType.getName());
        }

        for(int i = start;i<=end;i=i+step) {
            stringJoiner.add(String.valueOf(i));
        }
        return stringJoiner.toString();
    }
    
}
