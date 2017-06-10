import java.util.*;
public class ticket {

	static int INF = Integer.MAX_VALUE;
	static int n=4;
	
	static int minCostrec(int[][] cost,int s,int d)
	{
		if(s==d || s+1==d)
		{
			return cost[s][d];
		}
		int min = cost[s][d];
		
		for(int i=s+1;i<d;i++)
		{
			int c = minCostrec(cost,s,i)+minCostrec(cost,i,d);
			if(c<min)
			{
				min=c;;
			}
		}
		return min;
	}
	static int  minCost(int[][] cost)
	{
		return minCostrec(cost,0,n-1);
	}
	
	public static void main(String args[])
	{
		int cost[][] = { {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
              };
		System.out.println(minCost(cost));
	}
}
