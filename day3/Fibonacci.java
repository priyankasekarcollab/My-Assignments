package week1.day3;

public class Fibonacci {

	public static void main(String[] args) {
		int range = 8;
		int a=0;
		int b=1;
		System.out.print(a+","+b+",");
		for (int i = 2; i <range; i++) 
		{
			int nextvalue = a+b;
			System.out.print(nextvalue +",");
			a=b;
			b=nextvalue;
		}

	}

}
