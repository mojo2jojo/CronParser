package com.assignment.cronparser.fieldparser;

public class FieldParserFactory {
    
    public static FieldParser getFieldParser(String fieldName) {
        if(fieldName.equals("minute")) 
            return new FieldParserImpl(new FieldType(0, 59, "minute"));
        else if(fieldName.equals("hour"))
            return new FieldParserImpl(new FieldType(0, 23, "hour"));
        else if(fieldName.equals("day of month"))
            return new FieldParserImpl(new FieldType(1, 31, "day of month"));
        else if(fieldName.equals("month"))
            return new FieldParserImpl(new FieldType(1, 12, "month"));
        else if(fieldName.equals("day of week"))
            return new FieldParserImpl(new FieldType(1, 7,"day of week"));
        return null;
    }

}
