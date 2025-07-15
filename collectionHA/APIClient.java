package week4.collectionHA;

public class APIClient {
	
	//Creating method with single argument
	void sendRequest(String endpoint) {
		System.out.println(endpoint);
	}
	
	//Creating method with same name with multiple arguments
	void sendRequest(String endpoint, String requestBody,boolean requestStatus) {
		System.out.println(endpoint);
		System.out.println(requestBody);
		System.out.println(requestStatus);
	}

	public static void main(String[] args) {
		//Creating object to call the methods
		APIClient obj = new APIClient();
		obj.sendRequest("Hello");
		obj.sendRequest("Welcome", "Greetings for the day!", true);

	}

}
