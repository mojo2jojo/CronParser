package com.assignment.cronparser;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CronparserApplicationTests {

	// Boundary Value Testing

	@Test
	public void allFieldsAtMinValues() {
        CronparserApplication.main(new String[]{"*/15 0 1,15 * 1-5 /usr/bin/find"});
	}

	@Test
	public void allFieldsAtMaxValues() {
        CronparserApplication.main(new String[]{"59 23 31 12 7 /usr/bin/find"});
	}

	@Test
	public void minuteFieldsAtMaxStepValue() {
        CronparserApplication.main(new String[]{"*/59 0 1 1 1 /usr/bin/find"});
	}

	@Test
	public void hourFieldsAtMaxStepValue() {
        CronparserApplication.main(new String[]{"0 */23 1 1 1 /usr/bin/find"});
	}

	// Multiple Values and Ranges Testing

	@Test
	public void multipleValuesAndRange1() {
        CronparserApplication.main(new String[]{"1,5,10,15 0 1,15 1-6 1-5 /usr/bin/find"});
	}

	@Test
	public void multipleValuesAndRange2() {
        CronparserApplication.main(new String[]{"*/10 1-5,9-12 1-15 */2 1-4 /usr/bin/find"});
	}

	// Multiple Values and Ranges Testing

	@Test
	public void every5Min() {
        CronparserApplication.main(new String[]{"*/5 0-23 1-31 1-12 1-7 /usr/bin/find"});
	}

	public void complexStep() {
        CronparserApplication.main(new String[]{"1-59/2 0-23/3 1-31/5 1-12/2 1-7/4 /usr/bin/find"});
	}

	public void complexStep2() {
        CronparserApplication.main(new String[]{"*/15 0 1,15 * 1-5 /usr/bin/find"});
	}

	public void complexStep3() {
        CronparserApplication.main(new String[]{"0 0 31 12 7 /usr/bin/find"});
	}

	// Invalid Input Testing

	@Test
	public void invalidMinuteValue() {
		assertThrows(NumberFormatException.class, () -> CronparserApplication.main(new String[]{"abc 0 1 1 1 /usr/bin/find"}));
        
	}

	@Test
	public void invalidHourValue() {
		assertThrows(RuntimeException.class, () -> CronparserApplication.main(new String[]{"*/5 70 1 1 1 /usr/bin/find"}));
        
	}

	@Test
	public void invalidDayValue() {
		assertThrows(RuntimeException.class, () -> CronparserApplication.main(new String[]{"0 0 40 1 1 /usr/bin/find"}));
        
	}

	@Test
	public void invalidMonthValue() {
		assertThrows(RuntimeException.class, () -> CronparserApplication.main(new String[]{"0 0 1 13 1 /usr/bin/find"}));
	}
	
	@Test
	public void invalidWeekValue() {
		assertThrows(RuntimeException.class, () -> CronparserApplication.main(new String[]{"0 0 1 1 8 /usr/bin/find"}));
	}

	@Test
	public void missingCommnadValue() {
		assertThrows(IllegalArgumentException.class, () -> CronparserApplication.main(new String[]{"0 0 1 1 8"}));
	}

}
