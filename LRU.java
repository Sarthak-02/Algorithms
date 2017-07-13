import java.util.*;
import java.util.Map.Entry;
public class LRU {
	
	static void lru(int[] a){
		int n = a.length;
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++){
			
			if(map.size()<3){
				//System.out.println(i);
				map.put(a[i],i);
				
				continue;
			}
			else
			{
				
				if(map.containsKey(a[i])){
					map.replace(a[i], i);
				}
				else
				{
					//System.out.println("Hello");
					int leastRecUsed =least(map);
					//System.out.println("Hello");
					map.remove(leastRecUsed);
					map.put(a[i], i);
				}
				
			}
			for(Map.Entry<Integer, Integer> entry : map.entrySet()){
				System.out.print(entry.getKey()+" ");
			}
			System.out.println();
		}
		
		
	}
	static int least(Map<Integer, Integer> map){
		
		int min =Integer.MAX_VALUE;
		int index=0;
		//Iterator<Integer> itr = map.values().iterator();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        	
        	 
        	if(min>entry.getValue()){
        		min = entry.getValue();
        		index = entry.getKey();
        	}
        }
        
        return index; 
	}
	public static void main(String[] args){
		int[] a = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2};
		lru(a);
	
	}
}
