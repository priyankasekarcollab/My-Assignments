package week3.day3;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a= {3,2,11,4,6,7};
		int[] b= {1,2,8,4,9,7};
		System.out.println("The intersection values are: ");
		
		for (int i = 0; i < a.length; i++) {//outer loop for 1st array values
			for (int j = 0; j < b.length; j++) {//inner loop for 2nd array values
				if (a[i]==b[j]) {//comparing both array values
					System.out.println(a[i]);
				}
			}
		}

	}

}
