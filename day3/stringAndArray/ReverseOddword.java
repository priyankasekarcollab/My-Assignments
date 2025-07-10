package week3.day3;

public class ReverseOddword {

	public static void main(String[] args) {
		String test="I am a software tester";
		//Split the sentence with " "
		String[] split=test.split(" ");
		//loop to identify the position of the string
		for (int i = 0; i < split.length; i++) {
			if ((i+1)%2==0) {
				//The string that needs to be reversed is converted to char Array.
				char[] chars=split[i].toCharArray();
				//The string is reversed and printed
				for (int j = chars.length -1; j >=0; j--) {
					System.out.print(chars[j]);
					
				}
			}else {
				System.out.print(" "+split[i]+" ");
			}
		}
	}

}
