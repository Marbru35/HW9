package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Calendar;

class TestCalendar {
	
	GregorianCalendar gc = new GregorianCalendar();
	
	@ParameterizedTest
	@ValueSource(ints = { 1928, 1944, 1956, 1972, 1992 })
	public void Should_check_if_year_is_leap_also_in_gregorian(int year) {
		
		boolean expectedResult = gc.isLeapYear(year);
		
		Calendar c = new Calendar(year);
		boolean actualResult = c.isLeapYear();
		
		assertEquals(expectedResult, actualResult);
	}

// Implement test cases for the equivalent partitions 

	@ParameterizedTest
	@ValueSource(ints = { 1929, 1953, 1991 })
	public void Should_return_false_if_not_devisible_by_4(int year) {
		Calendar c = new Calendar(year);
		assertFalse(c.isLeapYear());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 1908, 1932, 1980 })
	public void Should_return_true_if_devisible_by_4_and_not_devisible_by_100(int year) {
		Calendar c = new Calendar(year);
		assertTrue(c.isLeapYear());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 1880, 1900 })  // Bedingung deckt ab: Should_return_false_if_devisible_by_4_and_devisible_by_100_and_not_devisible_by_400
	public void Should_return_false_if_less_equal_than_1900(int year) {
		Calendar c = new Calendar(year);
		assertFalse(c.isLeapYear());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 2000 })
	public void Should_return_true_if_devisible_by_4_and_devisible_by_100_and_devisible_by_400(int year) {
		Calendar c = new Calendar(year);
		assertTrue(c.isLeapYear());
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 2001, 2349, 2500 })
	public void Should_return_false_if_greater_than_2000(int year) {
		Calendar c = new Calendar(year);
		assertFalse(c.isLeapYear());
	}
}
