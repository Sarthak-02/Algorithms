package String_Algo;

public class BoyerMoore_badchar {

	static int bad_char(char c, char[] pat,int j)
	{
		while(j!=0)
		{
			j--;
			if(c == pat[j])
				break;
		}
		// System.out.println(j);
		return j;
	}
	static void match(char[] text,char[] pat)
	{
		int m = text.length;
		int n = pat.length;
		System.out.println(n);
		int i=0;
		int j;
		int s=0;
		while(i<m-n+1)
		{
			
			int flag=0;
			for(j=n-1;j>=0;j--)
			{
				if(text[j+i]!=pat[j])
				{
					flag=1;
					
					break;
				}
				
			}
			if(flag==1)
			{
				s = bad_char(text[j],pat,j+1);
				
				i=j+1+i-s;
				
			}
			else {
				System.out.println("Index at "+i);
				
				i = i+n;
				
				
			}
		
			
		}
	}
	public static void main(String args[])
	{
		String text = "ABCAABCD";
		String pat = "ABC";
		match(text.toCharArray(),pat.toCharArray());
	}
}
