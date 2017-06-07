package BitAlgorithm;
import java.util.*;

//Count total number of set bits in given integer
public class SetBits {
	static void count_setBits(int n)
	{
		int k = (int)(Math.log(n)/0.693)+1;
		//System.out.println(k);
		int count=0;
		for(int i=0;i<k;i++)
		{
			int set = n&1<<i;
			if(set>0)
				count++;
		}
		System.out.println(count);
	}

	public static void main(String args[])
	{
		int n = 7;
		
		count_setBits(n);
	}
}
