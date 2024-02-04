package com.assignment.cronparser;

import java.util.List;
import com.assignment.cronparser.utils.Utils;

public class CronparserApplication {

	public static void main(String[] args) {
		List<String> cronExpressionFieldList= getCronExpressionFieldList(args);
		ParsingHandler handler= new ParsingHandler(cronExpressionFieldList);
		String parsedExpression=handler.parseCronExpression();
		System.out.println(parsedExpression);
	}

	private static List<String> getCronExpressionFieldList(String[] args) {
		if (args.length != 1) 
			throw new IllegalArgumentException(Utils.getValidArgString(args));
        List<String> cronExpressionFieldList = List.of(args[0].trim().split("\\s"));
        if (cronExpressionFieldList.size() < 6) 
			throw new IllegalArgumentException(Utils.getValidArgString(args));
		return cronExpressionFieldList;
	}

}
