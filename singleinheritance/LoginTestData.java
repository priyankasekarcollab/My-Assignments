package week3.singleinheritance;

public class LoginTestData extends TestData{
	
	public void enterUsername() {
		System.out.println("Enter the username ----> Login Test data");
	}
	
	public void enterPassword() {
		System.out.println("Enter the password ----> Login Test data");
	}
	
	public static void main(String[] args) {
		
		LoginTestData obj = new LoginTestData();
		obj.enterCredentials();
		obj.navigateToHomePage();
		obj.enterUsername();
		obj.enterPassword();

	}

}
