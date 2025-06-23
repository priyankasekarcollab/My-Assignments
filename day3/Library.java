package week1.day3;

public class Library {
	String addbook(String bookTitle)
	{
		System.out.println("Book added successfully");
		return bookTitle;
	}
	void issuebook()
	{
		System.out.println("Book issued successfully");
	}

	public static void main(String[] args) {
		Library obj = new Library();
		obj.addbook("Java");
		obj.issuebook();

	}

}
