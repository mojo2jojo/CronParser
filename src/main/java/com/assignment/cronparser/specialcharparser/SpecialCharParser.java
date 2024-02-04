package com.assignment.cronparser.specialcharparser;

import com.assignment.cronparser.fieldparser.FieldType;

public interface SpecialCharParser {
    public String parseChar(String input, FieldType fieldType); 
}
