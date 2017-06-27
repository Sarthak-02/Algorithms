package String_Algo;
//https://stackoverflow.com/questions/8965926/algorithm-to-generate-all-combinations-of-a-string
public class StringCombination {
	
	static void comb(String s){
		int n = s.length();
		int num = 1<<n;
		int j=0;
		for(int i=0;i<num;i++){
			setBits(i,j,s);
			System.out.println();
		}
	}
	
	static void setBits(int i,int j,String s){
		if(i==0){
			return;
		}
		if(i%2==1){

			System.out.print(s.charAt(j));
						
		}
		
		setBits(i/2,j+1,s);
	}
	public static void main(String[] args){
		String s = "abcd";
		comb(s);
	}
}
