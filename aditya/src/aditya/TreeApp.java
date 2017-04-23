package aditya;
import java.io.*;


public class TreeApp {

	public static void main(String[] args) throws IOException
	{
	
	Tree theTree = new Tree();
	theTree.insert(50);
	theTree.insert(25);
	theTree.insert(75);
    theTree.insert(12);
	theTree.insert(37);
	theTree.insert(6);
    theTree.insert(18);
    theTree.insert(3);
	//theTree.insert(31);
    //theTree.insert(43);
    //theTree.insert(28);
	
    System.out.print("Before Reorientation :   ");
    theTree.preOrder(theTree.root);
    
    
    System.out.println();
    System.out.println();

    
    System.out.print("After Reorientation :    ");
    theTree.handleReorient();
	theTree.preOrder(theTree.root);
	
	
		
		
		
		
		
  /*Node adi=new Node();
	adi.iData=100;
	adi.color='B';
	
	Node aarav=new Node();
	aarav.iData=50;
	aarav.color='R';
	Tree.Test(adi,aarav);
*/	
	
	
	
	
	
	}
}
