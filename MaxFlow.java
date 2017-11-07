package Max_MIN_FLOW;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;

public class MaxFlow {

	class Edge {
		int to, from, res;
	}

	int V;
	ArrayList<Edge> adj[];

	MaxFlow(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	void addEdge(int from, int to, int res) {
		Edge e = new Edge();
		e.from = from;
		e.to = to;
		e.res = res;
		adj[from].add(e);
		Edge e1 = new Edge();
		e1.from = to;
		e1.to = from;
		e1.res = 0;
		adj[to].add(e1);

	}

	static int flow = 0;

	void BFS(int source, int sink) {

		ConcurrentHashMap<Integer, Integer> parent = new ConcurrentHashMap<>();
		ArrayList<Integer> path = new ArrayList<>();

		while (true) {
			boolean[] visited = new boolean[V];
			visited[source] = true;
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(source);
			outer: while (queue.size() != 0) {
				int curr = queue.poll();
				Iterator<Edge> itr = adj[curr].iterator();
				while (itr.hasNext()) {

					Edge e = itr.next();
					int n = e.to;
					int r = e.res;
					//System.out.println(curr+" "+n+" "+r);
					// System.out.println(curr+" "+n+" "+r);
					if (!visited[n] && r > 0) {

						visited[n] = true;
						queue.add(n);
						parent.put(n, curr);
						if (n == sink) {
							break outer;
						}
					}
				}
			}
			if(!parent.containsKey(sink)) {
				break;
			}
			int dist = sink;
			path.add(dist);
			while (true) {
				int x = parent.get(dist);
				path.add(x);
				dist = x;
				if (dist == source)
					break;
			}
			System.out.println(path);
			reduce(path);
			// System.out.println(path);
			parent.clear();
			path.clear();
		}

	}

	void reduce(ArrayList<Integer> path) {
		// System.out.println(path);
		Iterator<Integer> itr = path.iterator();
		int to = itr.next();
		int min = Integer.MAX_VALUE;
		while (itr.hasNext()) {
			int from = itr.next();
			// System.out.println(findMin(from,to));
			if (min > findMin(from, to)) {
				min = findMin(from, to);
			}
			to = from;
		}
		flow += min;
		itr = path.iterator();
		to = itr.next();
		// System.out.println(path);
		while (itr.hasNext()) {
			int from = itr.next();

			// System.out.println(from+" "+to);
			reverseResidue(from, to, min);
			to = from;
		}

		Iterator<Edge> itr1 = adj[1].iterator();
		while (itr1.hasNext()) {
			Edge e = itr1.next();
			//System.out.println(e.res);
		}
	}

	int findMin(int from, int to) {
		Iterator<Edge> itr = adj[from].iterator();
		// System.out.println(from+" "+to);
		int r = 0;
		while (itr.hasNext()) {
			Edge e = itr.next();
			if (e.to == to) {
				r = e.res;
				break;
			}
		}
		return r;
	}

	void reverseResidue(int from, int to, int min) {
		Iterator<Edge> itr = adj[from].iterator();
		while (itr.hasNext()) {
			Edge e = itr.next();
			if (e.to == to) {
				e.res = e.res - min;
			}
		}
		itr = adj[to].iterator();
		while (itr.hasNext()) {
			Edge e = itr.next();
			if (e.to == from) {
				e.res = e.res + min;
			}
		}
	}

	public static void main(String[] args) {
		MaxFlow obj = new MaxFlow(7);
		obj.addEdge(0, 1, 3);
		obj.addEdge(0, 3, 3);
		obj.addEdge(1, 2, 4);
		obj.addEdge(2, 0, 3);
		obj.addEdge(2, 3, 1);
		obj.addEdge(2, 4, 2);
		obj.addEdge(4, 1, 1);
		obj.addEdge(3, 5, 6);
		obj.addEdge(4, 6, 1);
		obj.addEdge(5, 6, 9);
		obj.BFS(0, 6);
		System.out.println(flow);
	}
}
