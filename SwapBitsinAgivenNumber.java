/*Given a number x and two positions (from right side) in binary representation of x, 
write a function that swaps n bits at given two positions and returns the result.
It is also given that the two sets of bits do not overlap. */




package BitAlgorithm;

public class SwapBitsinAgivenNumber {

	
	public static void main(String args[])
	{
		int x = 47;
		int p2 = 5;
		int p1 =1 ;
		int n=3;
		int t = (int)(Math.pow(2, n))-1;
		//System.out.println(Integer.toBinaryString(x));
		int set1 = x >> p2 & t;
		int set2 = x >> p1 & t;
		
		int xor =  set1^set2;
		
		xor = (xor << p2) | (xor << p1);
		int result = x ^ xor;
		System.out.println(result);
		
		
		
	}

}
