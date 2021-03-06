package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
A class that have no name is known as anonymous inner class in java. 
It should be used if you have to override method of class or interface. 
Java Anonymous inner class can be created by two ways:

1. Class (may be abstract or concrete).
2. Interface
 */

//	step 1

//abstract class
//abstract class Person{
//	abstract void eat();
//}
//concrete class
//class Person{ 
//	void eat() {
//		System.out.println("hello");
//	}
//}
//public class AnonymousClass1 {
//
//	public static void main(String[] args) {
//		Person p = new Person() {
//			@Override
//			void eat() {
//				System.out.println("nice fruits");
//				
//			}
//		};
//		p.eat();
//	}
//}
/**
 Internal working of given code
	Person p=new Person(){  
	void eat(){
	   System.out.println("nice fruits");
	 }  
	};  
	
	import java.io.PrintStream;  
	static class AnonymousClass1$1 extends Person  
	{  
	   AnonymousClass1$1(){}  
	   void eat()  
	    {  
	        System.out.println("nice fruits");  
	    }  
	}  
	
	1. A class is created but its name is decided by the compiler which extends the Person class 
	and provides the implementation of the eat() method.
	2. An object of Anonymous class is created that is referred by p reference variable of Person type.
	
**/

// step 2 using interface
//interface Eatable{
//	void eat();
//}
//class AnonymousClass1{
//	public static void main(String[] args) {
//		Eatable e = new Eatable() {
//			@Override
//			public void eat() {
//				 System.out.println("nice fruits");
//			}
//		};
//		e.eat();
//	}
//}
/**
 *Internal working of given code
It performs two main tasks behind this code:

Eatable p=new Eatable(){  
	void eat(){
	System.out.println("nice fruits");
	}  
};  

Internal class generated by the compiler

import java.io.PrintStream;  
static class AnonymousClass1$1 implements Eatable  
{  
    AnonymousClass1$1(){}  
	void eat(){
	System.out.println("nice fruits");
	}  
}  

A class is created but its name is decided by the compiler which implements the Eatable interface 
and provides the implementation of the eat() method.
An object of Anonymous class is created that is referred by e reference variable of Eatable type.
**/

class AnonymousClass1{
	public static void main(String[] args) {
		
		// step I
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				 System.out.println("nice fruits");
//			}
//		};
		//step II
//		Runnable r = () -> System.out.println("nice fruits");
//		Thread t = new Thread(r);
//		t.start();
//		System.out.println(isPrime3(5));

		List<Integer>numbers = Arrays.asList(1,2,3,4,5);
		//sum of all numbers
		System.out.println(sumWithCondition(numbers, n -> true));
		//sum of all even numbers
		sumWithCondition(numbers, i -> i%2==0);
		//sum of all numbers greater than 5
		sumWithCondition(numbers, i -> i>5);

	}

	//Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	
	//Declarative approach
	private static boolean isPrime2(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}
	
	// For more readability

	private static boolean isPrime3(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}

public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
Boolean


}