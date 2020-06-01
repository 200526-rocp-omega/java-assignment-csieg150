package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {
	static final double KPHTOMPH = 0.62137119223733; // The constant. kph * constant = mph value

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			if(kilometersPerHour < 0) {
				return -1L; // if negative, return negative 1 for 'error'
			}
			long MPH = Math.round(kilometersPerHour*KPHTOMPH); // Rounds the value
			return MPH;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			if(kilometersPerHour < 0) {
				return "Invalid Value"; // if negative, return error message
			}
			long MPH = Math.round(kilometersPerHour*KPHTOMPH); // gets the MPH
			String converted = kilometersPerHour + " km/h = " + MPH + " mi/h";
			return converted;
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {
		final int KB_PER_MB = 1024;
		if(kiloBytes < 0) {
			return "Invalid Value";
		}
		int mb = kiloBytes / KB_PER_MB; // get whole number of megabytes
		int kb = kiloBytes % KB_PER_MB; // get remainder of kilobytes
		String printMbAndKb = kiloBytes + " KB = " + mb + " MB and " + kb + " KB";
		return printMbAndKb;
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		if(hourOfDay > 23 || hourOfDay < 0 || !isBarking) { // if invalid time, or not barking
			return false;
		}
		if(isBarking &&(hourOfDay < 8 || hourOfDay >22)) { // if barking after 22 and before 8
			return true;
		}
		return false; // if barking but after 8 and before 23
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		final double ADD_THREE_DECIMAL = 1000;
		//Bring the three decimal places up and store these as ints for easy comparison
		int firstThreeDecimal = (int) ((firstNum * ADD_THREE_DECIMAL));
		int secondThreeDecimal = (int) ((secondNum * ADD_THREE_DECIMAL));
		if(firstThreeDecimal == secondThreeDecimal) {
			return true; // returns true if the decimals are equivalent
		}		
		return false; // returns false otherwise.
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			// TODO Write an implementation for this method declaration
			int[] range = {x,y,z};
			for(int i : range) {
				if(isTeen(i)) return true; // loops through input, if one is true then it 'has teen'
			}
			return false;
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			if(number >= 13 && number <=19) {
				return true; // if in the inclusive 13-19 range, it is a 'teen'
			}
			return false; // if not in the range, it is not a 'teen'
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) { // Guessing this rounds down, doesn't state
		if(minutes < 0L) {
			return "Invalid Value"; // Negative minutes invalid
		}
		final long MINUTES_PER_DAY = 1440L;
		final int DAYS_PER_YEAR = 365;
		
		int totalDays = (int) (minutes/MINUTES_PER_DAY); // total number of days
		int years = totalDays/DAYS_PER_YEAR; // total number of years
		int leftoverDays = totalDays%DAYS_PER_YEAR; // checks remainder of the days after the years calculated
		
		return (minutes + " min = " + years + " y and " + leftoverDays + " d");
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		switch(number) { // Determines case based on input, returns appropriate string
			case 0: return "ZERO"; 
			case 1: return "ONE";
			case 2: return "TWO"; 
			case 3: return "THREE"; 
			case 4: return "FOUR"; 
			case 5: return "FIVE"; 
			case 6: return "SIX";
			case 7: return "SEVEN";
			case 8: return "EIGHT";
			case 9: return "NINE"; 
			default: return "OTHER";
		}
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		if(first < 10 || second < 10) { // if either is below the range, return Invalid.
			return -1;
		}
		int greatestCommonDivisor = 0; // eventual return value.
		List<Integer> firstDivisors = new ArrayList<>(); // Establishes list to hold divisors.Not sure how many.
		for(int i = 1; i <= (first/2); i++) { // only covers up to 'first / 2', saving time and number of loops.
			if((first%i) == 0) {
				firstDivisors.add(i); // Adds the first divisor. i * (first/i) = first, so we just add both in one 'if' statement.
				firstDivisors.add((first/i));
			}
		} // ends with populating the first List.
		
		List<Integer> secondDivisors = new ArrayList<>(); // Establishes second list to hold divisors.Not sure how many.
		for(int i = 1; i <= (second/2); i++) { // only covers up to 'second / 2', saving time and number of loops.
			if((second%i) == 0) {
				secondDivisors.add(i); // Adds the first divisor. i * (first/i) = first, so we just add both in one 'if' statement.
				secondDivisors.add((second/i));
			}
		} // by now we have the list of both divisors. 
		
		
		for(Integer f : firstDivisors) { // checks each divisor against the other.
			for(Integer s: secondDivisors) {
//				System.out.println(f.toString()); // Just here for testing purposes.
//				System.out.println(s.toString());
				if((s.equals(f)) && (s > greatestCommonDivisor)) { // If a match and bigger than the current greatest, replaces it.
					greatestCommonDivisor = s; // Starts off at zero, and each list will always have at least '1' in common
				}
			}
		} // by the end of the loop we should have the greatest divisor. 
		
		
		return greatestCommonDivisor;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		// TODO Write an implementation for this method declaration
		if(num < 0) {
			return -1; // Any negative number is invalid
		}
		String value = String.valueOf(num); //Acquire the string format of the num to basically turn it into an array
		
		// Get index at 0, convert single char back to string
		// then use parseInt to turn it into a plain integer. parseInt does not accept chars directly.
		int first = Integer.parseInt(String.valueOf(value.charAt(0)));
		
		int last = Integer.parseInt(String.valueOf(value.charAt(value.length()-1))); // returns last index.
		
		// Together we have the 'first'and 'last' digits of a number and can sum them. I don't know why the instructions
		// suggested a loop.
		int sum = first + last;
		return sum;
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		if(string.length()<=1) {
			return string; // If empty string or 1 character, no need to do the rest.
		}
		char[] stringChars = new char[string.length()];
		for(int i = 0; i < string.length(); i++) {
			stringChars[i] = string.charAt(string.length()-1-i); // Adds chars in reverse order. 
		}
		String reversed = "";
		for(char c : stringChars) {
			reversed = reversed + c; // adds each reversed character to a new string
		}
		return reversed;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		// Would've liked it to be that only Uppercase Letters are what determine acronyms, but sadly not.
		// The test cases show that the char at index 0, and any char after " " or "-" are what make up the 
		String acronym = ""; //Sets up empty string for concatonation.
		boolean hasWhitespace = true;
		boolean hasHyphen = true;
		String nextSubstring = phrase;
		int nextWhitespace =0;
		int nextHyphen =0;
		while(hasWhitespace || hasHyphen) {
			// the two if statements check for the next index of whitespace and hyphen. If no more left, loop exit.
			if(nextSubstring.indexOf(" ") != -1) {
				nextWhitespace = nextSubstring.indexOf(" "); //returns first index of whitespace
			} else {
				hasWhitespace = false;
			}
			if(nextSubstring.indexOf("-") != -1) {
				nextHyphen = nextSubstring.indexOf("-"); //returns first index of hyphen
			} else {
				hasHyphen = false;
			}
			
			Character nextChar = Character.toUpperCase(nextSubstring.charAt(0));
			acronym = acronym + nextChar; // Adds the char at index 0 of the current string before cutting it to next substring or returning
			
			if(hasWhitespace && !hasHyphen) { // Case where only whitespaces remain. Most common and therefore first
				nextSubstring = nextSubstring.substring(nextWhitespace +1); // remove substring up to point of " " + 1, charat(0) is now the next acronym letter
			} else if(hasWhitespace && hasHyphen) {
				if(nextWhitespace < nextHyphen) {
					nextSubstring = nextSubstring.substring(nextWhitespace +1); // next whitespace comes first, so go there
				} else {
					nextSubstring = nextSubstring.substring(nextHyphen +1);  // next hyphen comes first, so go there. 
				}
			} else if(!hasWhitespace && hasHyphen) {
				nextSubstring = nextSubstring.substring(nextHyphen +1); // cut substring to right after the '-' 
			} else {
				return acronym; // If no more whitespace or hyphen, we should have all necesarry parts of the acronym.
			}
			
		}
		return acronym; //Here just in case of failure somehow.
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() { // All 3 sides equal
			if(sideOne == sideTwo && sideTwo == sideThree) { // If all match, it is Equilateral.
				return true;
			}
			return false;
		}

		public boolean isIsosceles() { // At LEAST 2 sides equal.
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) { // If any match, it is Isosceles.
				return true;
			}
			return false;
		}

		public boolean isScalene() { // No sides equal. Reverse of Isosceles test. 
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) { // If any match, not Scalene.
				return false;
			}
			return true;
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		string = string.toUpperCase(); // converts to uppercase just in the event input is lowercase, keep things uniform
		char[] chars = string.toCharArray(); // convert to char array for easy access of individual letters.
		int score = 0; // to display current score
		String onePoint = "AEIOULNRST"; // Gives 1 point
		String twoPoint = "DG"; // Gives 2 point
		String threePoint = "BCMP"; // Gives 3 point
		String fourPoint = "FHVWY"; // Gives 4 point
		String fivePoint = "K"; // Gives 5 point
		String eightPoint = "JX"; // Gives 8 point
		String tenPoint = "QZ"; // Gives 10 point
		
		for(int i = 0; i < chars.length; i++) { // loops through for each char and adds appropriate points
			String letter = "" + chars[i]; // Needed for using 'contains'
			if(onePoint.contains(letter)) {
				score += 1;
			} else if(twoPoint.contains(letter)) {
				score += 2;
			} else if(threePoint.contains(letter)) {
				score += 3;
			} else if(fourPoint.contains(letter)) {
				score += 4;
			} else if(fivePoint.contains(letter)) {
				score += 5;
			} else if(eightPoint.contains(letter)) {
				score += 8;
			} else if(tenPoint.contains(letter)) { // Doing this check just in case an invalid character appears
				score += 10;
			}
		}
		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		/*Had the idea for turning string into an array, checking if an index and its next 3 neighbors were int, 
		 * and then adding it to a second string when matching that criteria,
		 * but realistically I think I can do better via regex.
		 * 
		 * Using regex, Pattern and Matcher classes can pick out these groups of digits*/
		
//		if(string.charAt(0) == '1') { // This is in place during the event we expect people to lead off with 'country code'
//			string = string.substring(1);
//		}
		
		Pattern phoneString = Pattern.compile("(([2-9]\\d{2})\\D*(\\d{3})\\D*(\\d{4,}))"); 
		// The above should allow for people entering their 10 digit code entirely, 
		// as well as in groups of 3-3-4 or 3-7
		Matcher m = phoneString.matcher(string);
		
		String cleanNumber = ""; // Empty string for concatenation 
		
		if(m.find()) { //Checks to see there were matched patterns.
			for(int i = 2; i <= m.groupCount(); i++) { // For each matched group. Starts at 2 because thats where
				// the subgroups begin to add to the 'clean number'.
				cleanNumber = cleanNumber + m.group(i); // Adds each found group to the 'cleaned' number
			}

			if((cleanNumber.charAt(0) < 2) || (cleanNumber.length() != 10)) {
				throw new IllegalArgumentException(); //If area code starts off wrong or not enough characters, throw exception
			} 
		} else {
			throw new IllegalArgumentException(); // Not legal argument if it fails regex pattern
		}
		
		return cleanNumber;
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordCount = new HashMap<>();
		String[] words = string.split("\\h|,\\R|,|\\R"); // Need to split the string like this cause of testcases.
		// Covers white spaces, tabs, linebreaks, commas, and also commas followed by line breaks.
		
		for(String s : words) { // Loop through the split String array
			if(wordCount.containsKey(s)) { // If the map has the key:
				wordCount.replace(s, wordCount.get(s)+1); //Increment the value at that String key
			} else { // If it doesn't:
				wordCount.put(s, 1); // Add to map, initialize at 1
			}
		}
		return wordCount;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		boolean armstrong = false;
		int checkInput = 0;
		String inputString = "" + input; // converts to string for an easy char array
		double length = inputString.length(); // Used for Math.pow
		for(int i = 0; i < inputString.length(); i++) { // Loop through each character
			String charSegment = "" +inputString.charAt(i);
			checkInput = (int) (checkInput + Math.pow(Double.parseDouble(charSegment), length));
			// In the above, we get the sum of each char raised to the 'length' power.
			// For example, if we got 123 input, checkInput should go 1^3 + 2^3 + 3^3 because it is 3 characters long
		}
		if(input == checkInput) {
			armstrong = true;
		}
		return armstrong;
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		int[] numbers = new int[3];
		Random randGen = new Random();
		numbers[0] = randGen.nextInt(100) + 1; // Because nextInt(100) is a range of 0-99 we add 1
		numbers[1] = randGen.nextInt(100) + 1;
		numbers[2] = randGen.nextInt(100) + 1;
		return numbers;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		return 0;
	}
}
