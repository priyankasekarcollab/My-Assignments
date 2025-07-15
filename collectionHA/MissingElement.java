package week4.collectionHA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement {

	public static void main(String[] args) {
		//creating empty list
		List<Integer> num= new ArrayList<Integer>();
		
		//adding number to the list
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(10);
		num.add(6);
		num.add(8);
		
		//sorting the list
		Collections.sort(num);
		System.out.println("The sorted list is "+num);
		
		//Loop to find the missing element
		for (int i = 0; i < num.size()-1; i++) {
			
			if ((num.get(i)+1)!=num.get(i+1)) {
				System.out.println("The Missing number is "+(num.get(i)+1));
			
		}
		}
		
				
		

	}

}
