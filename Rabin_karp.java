package String_Algo;
import java.util.*;
public class Rabin_karp {
	
	static void match(char[] text, char[] pat,int q)
	{
		int m = pat.length;
		int n = text.length;
		int p=0;
		int t=0;
		
		for(int i=0;i<m;i++)
		{
			p = p+ ((int)(pat[i])-96)*(int)(Math.pow(q, i));
			
			t = t+ ((int)(text[i])-96)*(int)(Math.pow(q, i));
		}
		//System.out.println(p);
		int i=0;
		while(i<n-m+1)
		{
			if(p==t)
			{
				
				int k=0;
				int flag =0;
				
				for(int j=i;j<i+m;j++)
				{
					if(text[j]==pat[k])
					{
						k++;
						
					}
					else
					{
						 flag =1;
						 break;
					}
				}
				
				if(flag==0)
				{
					System.out.println("index at "+i);
					i = i+m;
				}
				else
				{
					i++;
				}
				
			}
			else
			{
				i++;
				t= (t - (int)(text[i-m]))/q + ((int)(text[i])-96)*(int)(Math.pow(q, m-1));
				
				
			}
		}
	}
	public static void main(String args[])
	{
		String text = "abedabc";
		String pat = "abe";
		int q=3;
		match(text.toCharArray(),pat.toCharArray(),q);
		
	}
}
