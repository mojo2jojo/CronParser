package com.assignment.cronparser;

import java.util.List;
import java.util.StringJoiner;

import com.assignment.cronparser.fieldparser.FieldParserFactory;
import com.assignment.cronparser.utils.Utils;

public class ParsingHandler {

    private List<String> cronExpressionFieldList;

    public ParsingHandler(List<String> cronExpressionFieldList) {
        this.cronExpressionFieldList=cronExpressionFieldList;
    }

    public String parseCronExpression() {
        StringJoiner output  = new StringJoiner("\n");
        
        for(int i=0;i<cronExpressionFieldList.size();++i) {
            if(i==0) {
                output.add(FieldParserFactory.getFieldParser("minute").parse(cronExpressionFieldList.get(i)));
            }
            else if(i==1) {
                output.add(FieldParserFactory.getFieldParser("hour").parse(cronExpressionFieldList.get(i)));
            }
            else if(i==2) {
                output.add(FieldParserFactory.getFieldParser("day of month").parse(cronExpressionFieldList.get(i)));
            }
            else if(i==3) {
                output.add(FieldParserFactory.getFieldParser("month").parse(cronExpressionFieldList.get(i)));
            }
            else if(i==4) {
                output.add(FieldParserFactory.getFieldParser("day of week").parse(cronExpressionFieldList.get(i)));
            }
            else {
                output.add(appendCommand());
                break;
            }
        }

        return output.toString();
    }

    public String appendCommand() {
        StringBuilder sb = new StringBuilder();
        String name="command";
        sb.append(name);
        for(int i=name.length();i<=Utils.nameColumnlength;i++) {
            sb.append(" ");
        }
        for(int i=5;i<cronExpressionFieldList.size();++i) {
            sb.append(cronExpressionFieldList.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }
    
}
