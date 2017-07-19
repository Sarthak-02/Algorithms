//package BitAlgorithm;
//To add two numbers without using Arithematic operator
public class Add_two_numbers {

	public static void main(String args[])
	{
		int a =10; //first number
		int b =12; //second number
		
		int c = a+b;
		
		int xor = a^b;
		int and = (a&b)<<1;
		int result = xor | and;
		System.out.println("Answer using arithmeatic operator"+c);
		System.out.println("Answer without using arithematic operator"+result);
		
	}
	
}
