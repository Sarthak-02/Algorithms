//http://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/
public class buildings {

	static int cal(int n){
		if(n==1)
		{
			return 1;
		}
		int cals =0;
		int calb=0;
		int prev_cals=1;
		int prev_calb=1;
		for(int i=2;i<=n;i++)
		{
			cals = prev_cals+prev_calb;
			calb = prev_cals;
			prev_cals=cals;
			prev_calb=calb;
		}
		return (cals+calb);
	}
	
	public static void main(String args[])
	{
		int n=4 ;
		int result = cal(n);
		System.out.println(result*result);
	}
}
