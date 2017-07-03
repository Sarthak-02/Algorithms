import java.util.*;
public class dfs_cycle {

	int V;
	static LinkedList adj[];
	
	dfs_cycle(int V){
		this.V = V;
		adj = new LinkedList[V];
		
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList();
		}
		
		
	}
	void addEdge(int u,int v){
		adj[u].add(v);
	}
	
	static void dfsUtil(int v,boolean[] visited){
		visited[v] = true;
		
		Iterator<Integer> itr =  adj[v].listIterator();
		
		while(itr.hasNext()){
			int i = itr.next();
			if(!visited[i]){
				dfsUtil(i,visited);
			}
			else
			{
				System.out.println("Cycle Detected");
			}
		}
	}
	
	void dfs(int s){
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++){
			visited[i] = false;
		}
		
		for(int i=0;i<V;i++){
			if(!visited[i]){
				dfsUtil(i,visited);
			}
		}
	}
	
	public static void main(String[] args){
		dfs_cycle obj = new dfs_cycle(6);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(2, 3);
		obj.addEdge(3, 4);
		obj.addEdge(4, 5);
		obj.addEdge(5, 2);
		obj.dfs(0);
	}
}
