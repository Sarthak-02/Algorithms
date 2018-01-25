package LinearSearch;

import java.util.*;
import java.io.*;

public class HolidaySeason {
	public static void main(String[] args) throws IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long[] arr = new long[26];
		char[] ch = s.toCharArray();
		int a,b,c,d;
		long ans=0;
		if(n<4) {
			pw.println(0);
		}else{
			for(b=0;b<n;b++) {
				for(d=b+1;d<n;d++) {
					if(ch[b]==ch[d]) {
						for(c=b+1;c<d;c++) {
							ans+=arr[ch[c]-'a'];
						}
					}
				}
				arr[ch[b]-'a']++;
			}
			pw.print(ans);
		}
		
		pw.flush();
		}
}
