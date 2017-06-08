package Search;
//Question @ http://www.geeksforgeeks.org/search-almost-sorted-array/
public class SearchinAlmostSortedArray {
	
	static void Search(int[] arr,int x)
	{
		int n =  arr.length;
		int r=n;int p=0;
		int mid = (p+r)/2;
		
		while(mid>=0 && mid <=n)
		{
			
			if(arr[mid]==x)
			{
				System.out.println("found at"+(mid));
				break;
			}
			if(arr[mid-1]==x)
			{
				System.out.println("found at"+(mid-1));
				break;
				
			}
			if(arr[mid+1]==x)
			{
				System.out.println("found at"+(mid+1));
				break;
			}
			else if(arr[mid]<arr[mid+2]){
				p = mid;
				mid = (p+r)/2;
			}
			else
			{
				r = mid;
				mid = (p+r)/2;
			}
				
		}
	}

	public static void main(String args[])
	{
		int[] arr = {10, 3, 40, 20, 50, 80, 70};
		int x = 80;
		Search(arr,x);
	}
	
}
