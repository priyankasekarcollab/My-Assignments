package week1.day3;

public class Palindrome {

	public static void main(String[] args) {
		int input = 121;
		int output=0;
		for (int i = input; i >0; i=i/10) 
		{
			int rem = i%10;
			output = output *10 +rem;
			
		}
		if (input == output) 
		{
			System.out.println("It is palindrome number");
			
		}
		else {
			System.out.println("It is not palindrome number");
		}
	}

}
