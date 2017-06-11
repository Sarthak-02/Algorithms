//http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
public class max_A {
	
	static int maxA(int n)
	{
		if(n<=7)
			return n;
		int[] a = new int[n];
		for(int i=1;i<=6;i++)
		{
			a[i-1]=i;
		}
			for(int i=7;i<=n;i++)
		{
			a[i-1]=0;
			for(int b=n-3;b>=1;b--)
			{
				int curr = (n-b-1)*maxA(b);
				if(curr>a[i-1])
				{
					a[i-1] = curr;
				}
			}
		}
		return a[n-1];
	}

	public static void main(String args[])
	{
		int  n = 15;
		System.out.println("maximum number of A's that can be printed are: " + maxA(n));
	}
}
