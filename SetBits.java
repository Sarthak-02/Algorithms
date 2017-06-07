package BitAlgorithm;
import java.util.*;

//Count total number of set bits from 1 to given integer
public class SetBits {
	static void count_setBits(int n)
	{
		int count=0;
		for(int i=1;i<=n;i++)
		{
			count+=countSetBit(i);
		}
		System.out.println(count);
	}

	static int countSetBit(int x)
	{
		if(x<=0)
		{
			return 0;
		}
		
		return (x%2==0? 0:1) + countSetBit(x/2);
	}
	public static void main(String args[])
	{
		int n = 4;
		
		count_setBits(n);
	}
}
