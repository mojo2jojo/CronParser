package com.assignment.cronparser.fieldparser;

import java.util.StringJoiner;

import com.assignment.cronparser.specialcharparser.DashParser;
import com.assignment.cronparser.specialcharparser.SlashParser;
import com.assignment.cronparser.specialcharparser.SpecialCharParser;
import com.assignment.cronparser.specialcharparser.StarParser;
import com.assignment.cronparser.utils.Utils;

public class FieldParserImpl implements FieldParser{

    private FieldType fieldType;
    private SpecialCharParser starParser= new StarParser();
    private SpecialCharParser dashParser= new DashParser();
    private SpecialCharParser slashParser= new SlashParser();
    

    public FieldParserImpl(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public String parse(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(fieldType.getName());
        for(int i=fieldType.getName().length();i<=Utils.nameColumnlength;i++) {
            sb.append(" ");
        }
        sb.append(parseMe(input));
        return sb.toString();
    }

    public String parseMe(String input) {

        if(input.strip().contains(",")) {
            return commaParser(input);
        } else if(input.strip().contains("/")) {
            return slashParser.parseChar(input,fieldType);
        } else if(input.strip().contains("-")) {
            return dashParser.parseChar(input,fieldType);
        } else if(input.strip().equals("*")) {
            return starParser.parseChar(input,fieldType);
        }

        Utils.validation(input,fieldType);

        return input;
    }

    public String commaParser(String input) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        String[] inputs = input.split(",");
        for(String inp : inputs) {
            stringJoiner.add(parseMe(inp));
        }
        return stringJoiner.toString();
    }

}
