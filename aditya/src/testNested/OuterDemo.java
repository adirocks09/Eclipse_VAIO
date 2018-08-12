package testNested;

//Outer Class can call inner Class [(public/private) or (static/instance) {methods/variables }] and inner class can also call outer class [(public/private) or (static/instance) {methods/variables }]
class OuterDemo {
   private int num=10;
   private static int num2=5;
   
   void instanceNum(){  //OuterClass instance Method
       System.out.println("Outer Class instance Method Called");

   }
   
   static void staticNum(){ //OuterClass static method
       System.out.println("Outer Class static Method Called");

   }
   
   // Accessing the private inner class members by creating instance method in outer class
     void display_Inner() {
	   
	   PrivateStaticInnerClass.getStaticAge();   //Calling Static method of private static inner class
	   PrivateStaticInnerClass innerStatic = new PrivateStaticInnerClass(); 
	   innerStatic.print();//Calling Instance method of private static inner class
	   
	   PrivateDynamicInnerClass innerDynamic = new PrivateDynamicInnerClass();
	   innerDynamic.print(); //Calling Instance method of private instance inner class
	   innerDynamic.getInstanceAge(); //Calling Instance method of private instance inner class
	   System.out.println(innerDynamic.abc); //Access to private members of inner class
   }
     
     // Accessing the private inner class members by creating static method in outer class
     static void displayInnerStatic() {
  	   
  	   PrivateStaticInnerClass.getStaticAge();   //Calling Static method of private static inner class
  	   PrivateStaticInnerClass innerStatic = new PrivateStaticInnerClass(); 
  	   innerStatic.print();//Calling Instance method of private static inner class
  	   System.out.println(innerStatic.q); //Access to private members of inner class
  	   System.out.println(PrivateStaticInnerClass.p); //Access to private members of inner class

  	  // PrivateDynamicInnerClass innerDynamic = new PrivateDynamicInnerClass(); //Gives error as PrivateDynamicInnerClass being non-static  
  	                                                                               //is directly being called from a static method : displayInnerStatic 
  	  
  	   PrivateDynamicInnerClass innerDynamic = new OuterDemo().new PrivateDynamicInnerClass(); //PrivateDynamicInnerClass(non-static) being indirectly called from static method : displayInnerStatic 
  	                                                                                           // by creating an instance of Outer class first and then creating
  	                                                                                           // an instance of the InnerClass on the instance of OuterClass

	   innerDynamic.print(); //Calling Instance method of private instance inner class
	   innerDynamic.getInstanceAge(); //Calling Instance method of private instance inner class
     }
   
// Private Non-Static inner class (Nested Class)
   private class PrivateDynamicInnerClass {
	  static final int x= 5;  // static declaration not allowed without "final" keyword
	  int y=10;
	  
	  private int abc=100;
	  
	  int getInstanceAge(){  // Static methods not allowed
		  return 10;
      }
	  
      public void print() {
          System.out.println("PrivateDynamicInnerDemo Method Called");
          num=num+1;
          instanceNum();    // Directly accessing Non Static method from Outer Class
          staticNum();      // Directly accessing Static method from Outer Class
      }
      
      //static block also not allowed
   }
 
   // Private Static inner class 
	private static class PrivateStaticInnerClass {
		static int p = 5;
		private int q = 10;

		static int getStaticAge() {
			return 10;
		}

		public void print() {
			System.out.println("PrivateStaticInnerDemo Method Called");
			staticNum(); // Directly accessing Static method from Outer Class
			OuterDemo outer = new OuterDemo(); // Accessing Non Static method from Outer Class By Creating objects of outer class
 			outer.instanceNum();
		}

		// static block allowed
		static {

		}
	}
	
	 //Public Non-Static Inner Class 
	 public class PublicDynamicInnerClass {
		  static final int x= 5;  // static declaration not allowed without "final" keyword
		  int y=10;
		  
		  int getInstanceAge(){  // Static methods not allowed
	    	  return 10;
	      }
		  
	      public void print() {
	          System.out.println("PublicDynamicInnerDemo Method Called");
	          num=num+1; //access to private non static members of outer class
	          num2=num2+1; //access to private static members of outer class
	          instanceNum();    // Directly accessing Non Static method from Outer Class
	          staticNum();      // Directly accessing Static method from Outer Class
	      }
	      
	      //static block also not allowed
	   }
	 
	   //Public Static Inner Class 
	        public static class PublicStaticInnerClass {
			static int p = 5;
			int q = 10;

			static int getStaticAge() {
				return 10;
			}

			public void print() {
				System.out.println("PublicStaticInnerDemo Method Called");
				staticNum(); // Directly accessing Static method from Outer Class
				//num=num+1; //Direct access to private non static members of outer class is not allowed
		        num2=num2+1; //access to private static members of outer class
				OuterDemo outer = new OuterDemo(); // Accessing Non Static method from Outer Class By Creating objects of outer class
	 			outer.instanceNum();
	 			outer.num+=1;

			}

			// static block allowed
			static {

			}
		}
}
   
