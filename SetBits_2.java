package BitAlgorithm;

public class SetBits_2 {
	
	
	static int  count_setBits(int n)
	{
		int x = (int)(Math.log(n)/0.693);
		if(n==0)
		{
			return 0;
		}
		
		return x*(int)(Math.pow(2, x-1)) + count_setBits(n-(int)(Math.pow(2, x))) + (n-(int)(Math.pow(2, x))+1);
	}

	public static void main(String args[])
	{
		int n=4;
		int ans=count_setBits(n);
		System.out.println(ans);
	}
}
