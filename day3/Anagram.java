package week3.day3;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 ="stops";
		String text2 ="potss";
		//Matching the lengths of String
		int l1=text1.length();
		int l2= text2.length();
		if (l1==l2) {
			
			//converting string to charArray
			char[] char1=text1.toCharArray();
			char[] char2=text2.toCharArray();
			
			//sorting the array
			Arrays.sort(char1);
			Arrays.sort(char2);
			
			//comparing the arrays
			if (Arrays.equals(char1,char2)) {
				System.out.println("The given strings are anagram");
			} else {
				System.out.println("The given strings are not anagram");
			}
			
		} else {
			System.out.println("Lenths mismatch, therefore the strings are not an Anagram");
		}

	}

}
