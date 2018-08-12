package coin;

import java.io.DataInputStream;

public class CoinDispensingApp {

	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(System.in);
		
		int denomination[]={10,5,2,1}; // load Denomination of coins in descending order
		int presentCount[]={10,10,10,10}; // load Initial Count of coins 
		int amt;
		System.out.println("Welcome to Coin Dispensing Machine");
		System.out.println("Initial Coins : ");
		for(int i=0;i<denomination.length;i++){
			System.out.print(denomination[i]+" : "+ presentCount[i]+"    ");
		}
		System.out.println();
		System.out.println("Do You Want to Continue \nPress 1 for YES , 2 for NO ");
		int choice1=Integer.parseInt(in.readLine());
		while(choice1==1){
			System.out.println("Press 1 to Withdraw Coins and 2 to Load Coins");
			int choice2=Integer.parseInt(in.readLine());
			if(choice2==1){
				System.out.println("Enter Amount :");
				amt=Integer.parseInt(in.readLine());
				int reqCoin[]=new int[4];
				dispenseCoins(amt,denomination,presentCount,reqCoin);
			}
			else if (choice2==2){
				for(int i=0;i<denomination.length;i++){
					System.out.print("How many " +denomination[i]+" rupees coins do you want to load :");
					int num=Integer.parseInt(in.readLine());
					presentCount[i]=presentCount[i]+num;
					System.out.println();
				}
				System.out.println("Coins Loaded Succesfully");
				System.out.println("Balance Coins : ");
				for(int i=0;i<denomination.length;i++){
					System.out.print(denomination[i]+" : "+ presentCount[i]+"    ");
				}
				System.out.println();

			}
			else{
				System.out.println("Wrong Choice....");
			}
			System.out.println("Do You Want to Continue \nPress 1 for YES and 2 for NO");
			choice1=Integer.parseInt(in.readLine());
		}
		System.out.println("Machine shutting DOWN..please Re-run the program");
	}

	private static void dispenseCoins(int amt, int[] denomination, int[] presentCount, int[] reqCoin) {

		for(int i=0;i<denomination.length;i++){
			reqCoin[i]=amt/denomination[i];
			if(presentCount[i]>reqCoin[i]){
				presentCount[i]=presentCount[i]-reqCoin[i];
				amt=amt%denomination[i];
				if(amt==0)
					break;
			}
			else{
				reqCoin[i]=presentCount[i];
				amt=amt-(presentCount[i]*denomination[i]);
				presentCount[i]=0;
			}
		}

		if(amt==0){
			System.out.println("Dispensed Coins : ");
			for(int i=0;i<denomination.length;i++){
				System.out.print(denomination[i]+ " : "+ reqCoin[i]+"    ");
			}
			System.out.println("\n-------------------------------");
			System.out.println("Balance Coins : ");
			for(int i=0;i<denomination.length;i++){
				System.out.print(denomination[i]+" : "+ presentCount[i]+"    ");
			}
			System.out.println("\n-------------------------------");

		}
		else{
			System.out.println("Cannot Dispense Coins worth Amount Entered");
			for(int i=0;i<denomination.length;i++){
				presentCount[i]=presentCount[i]+reqCoin[i];
			}
			System.out.println("Balance Coins : ");
			for(int i=0;i<denomination.length;i++){
				System.out.print(denomination[i]+":"+ presentCount[i]+"  ");
			}
			System.out.println("\n-------------------------------");
		}

	}

}
