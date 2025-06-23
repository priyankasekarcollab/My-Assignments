package week1.day3;

public class IsPrime {

	public static void main(String[] args) {
		int num =13;
		int count = 0;
		if(num<=1) 
		{
			System.out.println("It is not a prime number");
		}
		else {
			for (int i = 1; i <=num; i++) 
			{
				if (num%i ==0) 
				{
					count=count+1;
				}
			}
			if (count>2) 
			{
				System.out.println("It is not a prime number");
				
			} 
			else {
				System.out.println("It is a prime number");

			}
		}

	}

}
