package String_Algo;

public class SpaceString {
	static void spaceCombo(String s){
		StringBuffer sb = new StringBuffer();
		
		int n = s.length();
		int num = (1<<n)/2;
		for(int i=0;i<num;i++){
			
			int j=1;
			sb.append(s.charAt(0));
			spaceStringUtil(i,j,sb,s);
			sb.setLength(0);
		}
	}
	
	static void spaceStringUtil(int i,int j,StringBuffer sb,String s){
		if(i ==0){
			
			while(j!=s.length()){
				sb.append(s.charAt(j));
				j++;
			}
			System.out.println(sb);
			return;
		}
		if(i%2==1)
		{
			
			sb.append(" ");
			
		}
		sb.append(s.charAt(j));
		 spaceStringUtil(i/2,j+1,sb,s);
	}
	public static void main(String[] args){
		String s = "ABCD";
		spaceCombo(s);
	}
}
