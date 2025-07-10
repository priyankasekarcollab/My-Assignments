package week3.day3;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int count = 0;
		String text="We learn Java basics as part of java sessions in java Week1";
		//spliting the spring and storing it in array
		String[] split=text.split(" ");
		//both loops for comparing 1st text with remaining text
		for (int i = 0; i < split.length; i++) 
		{
			for (int j = i+1; j < split.length; j++) 
			{
				if (split[i].equalsIgnoreCase(split[j])) 
				{
					//If the both values matches assign the second value as empty string
					split[j]=" ";
					count = count+1;
				}
			}
		}
		if (count>1) 
		{
			//using loop to print the array values
			for (int a = 0; a < split.length; a++) 
			{
				System.out.print(split[a]+" ");
			}
		}

	}
}
