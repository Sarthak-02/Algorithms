package Graph;
import java.util.*;

import Disjoint.Disjoint_Set.Node;
public class KruskalMST {
	
	public class Edge implements Comparable<Edge>
	{

		long from , to ;
		int weight;
		//Comparator function is used to sort the edges on the basis of their weight.

		@Override
		public int compareTo(Edge compareEdge) {
			return this.weight-compareEdge.weight;
			
		}
		
	};
	
	int V; // no. of Vertices
	int E; //no. of Edges
	Edge edge[] ;//collection of all the edges
	//Creates a graph with V vertices and E edges 
	KruskalMST(int v, int e)
	{
		V=v;
		E=e;
		edge = new Edge[E];
		for(int i=0;i<e;i++)
		{
			edge[i]=new Edge();
		}
	}
	class disjoint_Set{
		class Node{
			long data;
			int rank;
			Node parent;
		}
		private Map<Long, Node> map = new HashMap<>();

		public void makeSet(long data) {
			Node node = new Node();
			node.data =  data;
			node.parent = node;
			node.rank = 0;
			map.put(data, node);

		}
		public long findSet(long data) {
			return findSet(map.get(data)).data;
		}

		private Node findSet(Node node) {
			Node parent = node.parent;
			if (parent == node) {
				return parent;
			}
			node.parent = findSet(node.parent);
			return node.parent;
		}

		public boolean union(long data1, long data2) {
			Node node1 = map.get(data1);
			Node node2 = map.get(data2);

			Node parent1 = findSet(node1);
			Node parent2 = findSet(node2);
			// if they are part of the same set do nothing.
			if (parent1.data == parent2.data) {
				return false;
			}
			// else whoever's rank is higher becomes parent of other.
			if (parent1.rank >= parent2.rank) {
				// increment rank only if both sets have same rank
				parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
				parent2.parent = parent1;
			} else {
				parent1.parent = parent2;
			}
			return true;
		}
	}
	
	
	void mst()
	{
		Edge result[] = new Edge[V]; //This will store the resultant graph
		int i ;
		for(i=0;i<V;i++)
		{
			result[i] = new Edge();
		}
		
		Arrays.sort(edge);//sort the edges in non-decreasing  order of their weight
		
		disjoint_Set ds = new disjoint_Set();
		for(int j=0;j<V;j++)
		{
			ds.makeSet(j);
		}
		
		int e=0;//index value for resultant graph
		i=0;// index used to pick next edge
		/*the resultant graph will have v-1 edges */
		while(e<V-1){
			Edge next_edge = new Edge();
			next_edge = edge[i];//pick the smallest edge and increment the index for next iteration
			i++;
			int x=(int) ds.findSet(next_edge.from);
			int y = (int) ds.findSet(next_edge.to);
			if(x!= y)
			{
				result[e] = next_edge;
				e++;
				ds.union(next_edge.from,next_edge.to);
			}
			//Else discard the edge
		}
		
		//print the content of the result 
		for(i=0;i<e;i++)
		{
			System.out.println(result[i].from+"---"+result[i].to+"=="+result[i].weight);
		}
	}
	public static void main(String args[])
	{
		int V = 4;
		int E = 5;
		KruskalMST km = new KruskalMST(V,E);
		
		km.edge[0].from=0;
		km.edge[0].to=1;
		km.edge[0].weight=10;
		
		km.edge[1].from=0;
		km.edge[1].to=2;
		km.edge[1].weight=6;
		
		km.edge[2].from=0;
		km.edge[2].to=3;
		km.edge[2].weight=5;
		
		km.edge[3].from=1;
		km.edge[3].to=3;
		km.edge[3].weight=15;
		
		km.edge[4].from=2;
		km.edge[4].to=3;
		km.edge[4].weight=4;
		km.mst();
		
	}

}
