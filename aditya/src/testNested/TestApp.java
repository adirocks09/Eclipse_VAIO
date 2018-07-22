package testNestedClass;

import testNestedClass.OuterDemo.PublicDynamicInnerClass;

public class TestApp {

	   public static void main(String args[]) {
	      // Instantiating the outer class and accessing private nested classes by Calling Instance method on Outer Class
		   OuterDemo outer = new OuterDemo();
  	       outer.display_Inner();
	    
  	       //accessing private nested classes by Calling Static method on Outer Class
  	       OuterDemo.displayInnerStatic();
  	      
	      PublicDynamicInnerClass obj1 = new OuterDemo().new PublicDynamicInnerClass(); //accesing public dynamic nested classes
	      obj1.getInstanceAge();
	      obj1.print();
	      
	      OuterDemo.PublicStaticInnerClass.getStaticAge();
	      OuterDemo.PublicStaticInnerClass  obj2= new OuterDemo.PublicStaticInnerClass(); //accesing public static nested classes
	      obj2.print();
	      
	       // Gives error because the visibility is private
	      // OuterDemo.PrivateDynamicInnerClass obj3 = new OuterDemo().new PrivateDynamicInnerClass();
	     // OuterDemo.PrivateStaticInnerClass  obj4= new OuterDemo.PrivateStaticInnerClass();

	   }
	}