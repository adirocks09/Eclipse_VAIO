package wallmart;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public class ShopApp {
	public static final int Shelves=10; // A,B,C,D,E,F,G,H,I,J
	public static final int Columns=20; // 1,2,3,4,5...........18,19,20

	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(System.in);

		// String locProduct = "H8"; // Location FORMAT
		// String locCustomer = "D2";
		
		System.out.println("Enter Location of Product");
		String locProduct = in.readLine();  // Example A12,B16,H9
		System.out.println("Enter Location of Customer");
		String locCustomer = in.readLine();

		List<String> path = new ArrayList<String>();

		char productXCoordinate = Character.toUpperCase((locProduct.charAt(0)));
		int productYCoordinate = Integer.parseInt((locProduct.substring(1, locProduct.length())));

		char customerXCoordinate = Character.toUpperCase(locCustomer.charAt(0));
		int customerYCoordinate = Integer.parseInt((locCustomer.substring(1, locCustomer.length())));

		int rightDist = calculateRightPathDistance(productYCoordinate, customerYCoordinate);
		System.out.println("Right Distance =  " + rightDist);
		int leftDist = calculateLeftPathDistance(productYCoordinate, customerYCoordinate);
		System.out.println("Left Distance =  " + leftDist);
		if (rightDist <= leftDist) {
			System.out.println("Following Right Route");
			path = followRightPath(productXCoordinate, productYCoordinate, customerXCoordinate, customerYCoordinate);
		} else {
			System.out.println("Following Left Route");
			path = followLeftPath(productXCoordinate, productYCoordinate, customerXCoordinate, customerYCoordinate);
		}

		for (String p : path) {
			System.out.print(p + " , ");
		}
		System.out.println();
	}

	private static List<String> followLeftPath(char productXCoordinate, int productYCoordinate, char customerXCoordinate,
			int customerYCoordinate) {
		 List<String> path = new ArrayList<String>();
		 for(int i=customerYCoordinate;i>1;i--){
			 path.add(customerXCoordinate+""+i);
		 }
		 if(productXCoordinate>customerXCoordinate){
			 while(customerXCoordinate<productXCoordinate){
				path.add(Character.toString(customerXCoordinate)+1);
				customerXCoordinate+=1;
			 }
		 }
		 else{
			 while(customerXCoordinate>productXCoordinate){
				path.add(Character.toString(customerXCoordinate)+1);
				customerXCoordinate-=1;
			 }
		 }
		 for(int i=1;i<=productYCoordinate;i++){
			 path.add(productXCoordinate+""+i);
		 }
		return path;
	}

	private static List<String> followRightPath(char productXCoordinate, int productYCoordinate, char customerXCoordinate,
			int customerYCoordinate) {
		 List<String> path = new ArrayList<String>();
		 for(int i=customerYCoordinate;i<Columns;i++){
			 path.add(customerXCoordinate+""+i);
		 }
		 if(productXCoordinate>customerXCoordinate){
			 while(customerXCoordinate<productXCoordinate){
				path.add(Character.toString(customerXCoordinate)+Columns);
				customerXCoordinate+=1;
			 }
		 }
		 else{
			 while(customerXCoordinate>productXCoordinate){
				path.add(Character.toString(customerXCoordinate)+Columns);
				customerXCoordinate-=1;
			 }
		 }
		 for(int i=Columns;i>=productYCoordinate;i--){
			 path.add(productXCoordinate+""+i);
		 }
		return path;

	}

	private static int calculateLeftPathDistance(int productYCoordinate, int customerYCoordinate) {
		int leftDist = (customerYCoordinate-1)+(productYCoordinate-1);
		return leftDist;
	}

	private static int calculateRightPathDistance(int productYCoordinate, int customerYCoordinate) {
		int rightDist = (Columns-customerYCoordinate)+(Columns-productYCoordinate);
		return rightDist;
		
	}

}
