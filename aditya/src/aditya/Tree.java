package aditya;

public class Tree
{
Node root; // first node of tree
Node current; // start at root
Node parent;
Node grand;
Node great;
Node ancestor;
Node newNode;
boolean isColorFlip;


// -------------------------------------------------------------
public Tree() // constructor
{
	root = null;
} // no nodes in tree yet

public void insert(int id)
{
	
newNode = new Node(); // make new node
newNode.iData = id; // insert data
newNode.color='R';

if(root==null)
{ 
	// no node in root
root = newNode;
root.color='B';

}

else // root occupied
{
	
current = root; // start at root
great=grand=parent=root;

while(true) // (exits internally)
{
ancestor=great;
great=grand;
grand=parent;
parent = current;

if(parent!=null)
{
	if(parent.leftChild!=null&&parent.rightChild!=null)
		parent=colorFlip(parent);
	
	if(isColorFlip==true)
	{
		checkRedRedConflict(parent);
	}
}



if(id < current.iData) // go left?
{
current = current.leftChild;
if(current == null) // if end of the line,
{
    parent.leftChild = newNode;
    
    
    if (parent.color=='R'&& parent.iData<grand.iData)
	{
    	
		if(grand.color=='B')
			grand.color='R';
		else
			grand.color='B';
		
		
		parent.color='B';
		
		if(grand!=root)
		{	
		    grand=rotateWithRightChild(grand);
		
		    if(grand.iData<great.iData)
		       great.leftChild=grand;
		    else
			   great.rightChild=grand;				
		}
		else
		    root=rotateWithRightChild(root);

	}
    
    else if (parent.color=='R'&& parent.iData>grand.iData)
    {
    	if(grand.color=='B')
			grand.color='R';
		else
			grand.color='B';
    	
    	if(newNode.color=='B')
    		newNode.color='R';
		else
			newNode.color='B';
    	
    	parent=rotateWithRightChild(parent);
    	if(parent.iData<grand.iData)
		    grand.leftChild=parent;
		else
			grand.rightChild=parent;
		    	
    	if(grand!=root)
    	{
		    grand=rotateWithLeftChild(grand);
		    if(grand.iData<great.iData)
		        great.leftChild=grand;
		    else
			    great.rightChild=grand;
    	}
    	else
    		root=rotateWithLeftChild(root);
	
    }
return;
}
} // end if go left


else // or go right?
{
	current = current.rightChild;
    	
	if(current == null) // if end of the line
	{ // insert on right
	parent.rightChild = newNode;
	
	if (parent.color=='R'&& parent.iData>grand.iData)
	{
    	
		if(grand.color=='B')
			grand.color='R';
		else
			grand.color='B';
		
		
		parent.color='B';
		
		if(grand!=root)
		{
		     grand=rotateWithLeftChild(grand);	
		     if(grand.iData<great.iData)
		         great.leftChild=grand;
		     else
			    great.rightChild=grand;
		}
		else
		     root=rotateWithLeftChild(root);	

	}
    
	else if (parent.color=='R'&& parent.iData<grand.iData)
    {
    	if(grand.color=='B')
			grand.color='R';
		else
			grand.color='B';
    	
    	if(newNode.color=='B')
    		newNode.color='R';
		else
			newNode.color='B';
    	
    	
    	parent=rotateWithLeftChild(parent); 
    	if(parent.iData<grand.iData)
		    grand.leftChild=parent;
		else
			grand.rightChild=parent;
		    	
    	if(grand!=root)
    	{
    	    grand=rotateWithRightChild(grand); 
    	    if(grand.iData<great.iData)
		        great.leftChild=grand;
		    else
			    great.rightChild=grand;
    	}
    	else
    	    root=rotateWithRightChild(root);   	
    }
		return;
	}
	} 	
    } 	
    }         
    } // end insert()
	// -------------------------------------------------------------

public void preOrder(Node localRoot)
{
if(localRoot != null)
{
System.out.print(localRoot.iData + ""+localRoot.color+"    ");
preOrder(localRoot.leftChild);
preOrder(localRoot.rightChild);
}
}
// -------------------------------------------------------------



public Node rotateWithRightChild(Node k2)
{
 Node k1=k2.leftChild;
 k2.leftChild=k1.rightChild;
 k1.rightChild=k2;
 return k1;
}


public Node rotateWithLeftChild(Node k1)
{
	Node k2=k1.rightChild;
	k1.rightChild=k2.leftChild;
	k2.leftChild=k1;
	return k2;
    
}




public Node colorFlip( Node localCurrent)
{
    isColorFlip=false;	
	if (localCurrent.color=='B'&&localCurrent.leftChild.color=='R'&&localCurrent.rightChild.color=='R')
	{
		if(localCurrent!=root)
			localCurrent.color='R';
		
		localCurrent.leftChild.color='B';
		localCurrent.rightChild.color='B';		
		isColorFlip=true;
	}
	return localCurrent;
}

public void checkRedRedConflict(Node localParent)
{
	if(localParent.color=='R'&&grand.color=='R')
	{
		
		if((localParent.iData<grand.iData)&&(grand.iData<great.iData))
		{
			if(great.color=='B')
				great.color='R';
			else
				great.color='B';
			
			
			grand.color='B';
			
			if(great==root)
			{
			   root=rotateWithRightChild(root);	  
			}
			
			else
			{
				 great=rotateWithRightChild(great);	
				 if(great.iData<ancestor.iData)
					 ancestor.leftChild=great;
				 else
					 ancestor.rightChild=great;
			}
			   return;
		}
		else if((localParent.iData>grand.iData)&&(grand.iData>great.iData))
		{
			if(great.color=='B')
				great.color='R';
			else
				great.color='B';
			
			
			grand.color='B';
			
			if(great==root)
			{
			   root=rotateWithLeftChild(root);	  
			}
			
			else
			{
				 great=rotateWithLeftChild(great);	
				 if(great.iData<ancestor.iData)
					 ancestor.leftChild=great;
				 else
					 ancestor.rightChild=great;
			}
			   return;
		}
		
		else if(localParent.iData>grand.iData&&grand.iData<great.iData)
		{
			if(great.color=='B')
				great.color='R';
			else
				great.color='B';
			
			localParent.color='B';
			
			grand=rotateWithLeftChild(grand);
			if(grand.iData<great.iData)
				great.leftChild=grand;
			else
				great.rightChild=grand;
			
			if(great==root)
			{
			   root=rotateWithRightChild(root);	  
			}
			
			else
			{
				 great=rotateWithRightChild(great);	
				 if(great.iData<ancestor.iData)
					 ancestor.leftChild=great;
				 else
					 ancestor.rightChild=great;
			}
            return;
		}
		
		else if(localParent.iData<grand.iData&&grand.iData>great.iData)
		{
			if(great.color=='B')
				great.color='R';
			else
				great.color='B';
			
			localParent.color='B';
			
			grand=rotateWithRightChild(grand);
			if(grand.iData<great.iData)
				great.leftChild=grand;
			else
				great.rightChild=grand;
			
			if(great==root)
			{
			   root=rotateWithLeftChild(root);	  
			}
			
			else
			{
				 great=rotateWithLeftChild(great);	
				 if(great.iData<ancestor.iData)
					 ancestor.leftChild=great;
				 else
					 ancestor.rightChild=great;
			}
            return;
		}
		
		
	}	
}		

public void handleReorient()
{
  if(root!=null&&root.leftChild!=null&&root.rightChild!=null)
  {
	  root.color='B';
	  root.leftChild.color='B';
	  root.rightChild.color='B';
  }
	/*if(parent!=null&&parent.leftChild!=null&&parent.rightChild!=null)
	{	
	   if (parent.color=='B'&&parent.leftChild.color=='R'&&parent.rightChild.color=='R')
	      {
		     if(parent!=root)
			     parent.color='R';
		
		     parent.leftChild.color='B';
		     parent.rightChild.color='B';		
		
	       }
	}*/
	
	return;
}

 /*public static void Test(Node a,Node b)
 {
	a.leftChild=b;
	b.color='X';
	System.out.println("color of child"+"="+b.color);
	System.out.println("color of parent's child"+"="+a.leftChild.color);

 }
 */
 
}

