package week4.collectionHA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargeNumHA {

	public static void main(String[] args) {
		//Empty list is created
		List<Integer> num=new ArrayList<Integer>();
		
		// numbers are added to list
		num.add(3);
		num.add(2);
		num.add(11);
		num.add(4);
		num.add(6);
		num.add(7);
		
		//Sorted the list
		Collections.sort(num);
		System.out.println("The List is sorted in ascending order: "+num);
		
		//Printing 2nd large number in list
		int index=num.size()-2;
		System.out.println("The second largest num is "+num.get(index));

	}

}
