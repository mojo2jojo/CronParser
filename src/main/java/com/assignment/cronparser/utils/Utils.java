package com.assignment.cronparser.utils;

import com.assignment.cronparser.fieldparser.FieldType;

public class Utils {

    public static final int nameColumnlength = 14;

    public static String getValidArgString(String[] passedArg) {
        String merged="";
        for(String str: passedArg)
            merged=merged+str;
        return "Expected [minute] [hour] [day of month] [day of week] [command] but got : " + merged;
    }

    public static void validation(String value, FieldType fieldType) {
        try {
            int integerValue = Integer.valueOf(value);
            if( integerValue >= fieldType.getLow() && integerValue <= fieldType.getHigh()) {
                return;
            }
            throw new RuntimeException("Invalid value for " + fieldType.getName());

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid value for " + fieldType.getName());
        }
    }

}
