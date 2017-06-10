import java.util.*;
public class Max_profit {
//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
	static void maxProfit(int price[],int t)
	{
	//	
		int res=0;
		int n=t;
	for(int j=0;j<2;j++)
	{
		
		int max_diff = 0;
		int min = price[0];
		
		int p=0;int q=0;
		for(int i=0;i<n;i++)
		{
			if(price[i]<0)
			{
				i++;
				continue;
			}
			if(price[i]-min>max_diff)
			{
				max_diff = price[i]-min;
				p=i;
			}
			if(price[i]<min)
			{
				min = price[i];
				q=i;
			}
		}
		price[p]=-1;
		price[q]=-1;
		res = res+max_diff;
		int k=0;
		/*for(int i=0;i<n;i++)
		{
			if(price[i]<0)
			{
				i++;
			}
			price[k]=price[i];
			k++;
		}
		n=n-2;*/
	}
		
		
		System.out.println(res);
	}
	
	public static void main(String args[])
	{
		int price[]  = {100, 30, 15, 10, 8, 25, 80};
		maxProfit(price,price.length);
	}
}
