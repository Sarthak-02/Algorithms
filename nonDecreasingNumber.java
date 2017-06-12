//http://www.geeksforgeeks.org/total-number-of-non-decreasing-numbers-with-n-digits/

public class nonDecreasingNumber {

	static int num(int n)
	{
		if (n==1)
		{
			return 10;
		}
		int[] a = new int[10];
		int[] prev_a = new int[10];
		for(int i=0;i<10;i++)
		{
			prev_a[i] = 1;
		}
		int sum = 10;
		int res=0;
		//a[0]=10;
		for(int d=1;d<n;d++)
		{
			
			
			a[0]=sum;
			
			for(int i=1;i<10;i++)
			{
				a[i] = a[i-1]-prev_a[i-1];
				
				sum =sum+ a[i];
				
			}
			for(int i=0;i<10;i++)
			{
				prev_a[i]=a[i];
			}
			
		}
		
		return sum;
	} 
	public static void main(String args[])
	{
		int n = 4;
		System.out.println(num(n));
		
	}
}
