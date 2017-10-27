package MinimumSpanningTree;

import java.util.*;

import MinimumSpanningTree.BinaryMinHeap.Node;

import java.io.*;

public class PrimMST {
	class BinaryMinHeap<T> {
		List<Node> allNodes = new ArrayList<>();
		HashMap<T, Integer> nodePosition = new HashMap<>(); // key and its position

		class Node {
			int weight;
			T key;
		}

		// Check whether the key exists in heap or not
		public boolean containsData(T key) {
			return nodePosition.containsKey(key);
		}

		// Get the minimum
		public T min() {
			return allNodes.get(0).key;
		}

		// check if boolean is empty
		public boolean empty() {
			return allNodes.size() == 0;
		}

		// Get the weight of the given key
		public Integer getWeight(T key) {
			Integer pos = nodePosition.get(key);
			if (pos == null) {
				return null;
			} else {
				return allNodes.get(pos).weight;
			}
		}

		void swap(Node node1, Node node2) {
			int weight = node1.weight;
			T data = node1.key;
			node1.key = node2.key;
			node1.weight = node2.weight;

			node2.weight = weight;
			node2.key = data;
		}

		void updatepositionMap(T key1, T key2, int pos1, int pos2) {
			nodePosition.remove(key1);
			nodePosition.remove(key2);
			nodePosition.put(key1, pos1);
			nodePosition.put(key2, pos2);
		}

		// Add key and its weight to the heap

		public void add(int weight, T key) {
			Node node = new Node();
			node.weight = weight;
			node.key = key;

			allNodes.add(node);

			int size = allNodes.size();

			int curr = size - 1; // since index starts with 0;

			int parentIndex = (curr - 1) / 2;

			nodePosition.put(node.key, curr);

			while (parentIndex >= 0) {
				Node parentNode = allNodes.get(parentIndex);
				Node currentNode = allNodes.get(curr);
				if (parentNode.weight > currentNode.weight) {
					swap(parentNode, currentNode);
					updatepositionMap(parentNode.key, currentNode.key, parentIndex, curr);
					curr = parentIndex;
					parentIndex = (parentIndex - 1) / 2;
				} else {
					break;
				}
			}
		}

		public void decrease(T data, int newWeight) {
			Integer position = nodePosition.get(data);
			allNodes.get(position).weight = newWeight;
			int parent = (position - 1) / 2;
			while (parent >= 0) {
				if (allNodes.get(parent).weight > allNodes.get(position).weight) {
					swap(allNodes.get(parent), allNodes.get(position));
					updatepositionMap(allNodes.get(parent).key, allNodes.get(position).key, parent, position);
					position = parent;
					parent = (parent - 1) / 2;
				} else {
					break;
				}
			}
		}

		public Node extractMinHeap() {
			int size = allNodes.size() - 1;
			Node minNode = new Node();
			minNode.key = allNodes.get(0).key;
			minNode.weight = allNodes.get(0).weight;

			int lastNodeWeight = allNodes.get(size).weight;
			allNodes.get(0).weight = lastNodeWeight;
			allNodes.get(0).key = allNodes.get(size).key;
			nodePosition.remove(minNode.key);
			nodePosition.remove(allNodes.get(0));
			nodePosition.put(allNodes.get(0).key, 0);
			allNodes.remove(size);

			int currentIndex = 0;
			size--;
			while (true) {
				int left = 2 * currentIndex + 1;
				int right = 2 * currentIndex + 2;
				if (left > size) {
					break;
				}
				if (right > size) {
					right = left;
				}
				int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
				if (allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight) {
					swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
					updatepositionMap(allNodes.get(currentIndex).key, allNodes.get(smallerIndex).key, currentIndex,
							smallerIndex);
					currentIndex = smallerIndex;
				} else {
					break;
				}
			}
			return minNode;
		}

		public T extractMin() {
			Node node = extractMinHeap();
			return node.key;
		}

		public void printHeap() {
			Iterator itr = allNodes.iterator();
			while (itr.hasNext()) {
				Node n = (Node) itr.next();
				System.out.println(n.key + " " + n.weight);
			}
		}
	}

	class Edge {
		int vertex1, vertex2, weight;
	}

	int V;// no. of vertex
	int E;// no. of Edges

	ArrayList<Edge> adj[];

	PrimMST(int v, int e) {
		V = v;
		E = e;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

	}

	void addEdge(int vertex1, int vertex2, int weight) {
		Edge e = new Edge();
		e.vertex1 = vertex1;
		e.vertex2 = vertex2;
		e.weight = weight;
		adj[vertex1].add(e);
		adj[vertex2].add(e);
	}

	void pmst() {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>();
		for (int i = 0; i < V; i++) {
			heap.add(Integer.MAX_VALUE, i);
		}
		heap.decrease(0, 0);
		Map<Integer, Edge> vertexToEdge = new HashMap<>();
		// Edge[] result = new Edge[V];
		ArrayList<Edge> result = new ArrayList<>();

		while (!heap.empty()) {

			int current = heap.extractMin();
			Edge spanningTreeEdge = vertexToEdge.get(current);
			// System.out.println(spanningTreeEdge.from);
			if (spanningTreeEdge != null) {
				result.add(spanningTreeEdge);
			}

			// iterate through all the adjacent edges
			Iterator<Edge> itr = adj[current].iterator();
			while (itr.hasNext()) {
				Edge edge = itr.next();
				int adjacent = getVertexFromEdge(current, edge);
				if (heap.containsData(adjacent) && heap.getWeight(adjacent) > edge.weight) {
					heap.decrease(adjacent, edge.weight);
					vertexToEdge.put(adjacent, edge);
				}
			}
		}
		Iterator<Edge> itr = result.iterator();
		while (itr.hasNext()) {
			Edge x = itr.next();
			System.out.println(x.vertex1 + " " + x.vertex2 + " " + x.weight);
		}

	}

	int getVertexFromEdge(int current, Edge edge) {
		if (edge.vertex1 == current) {
			return edge.vertex2;
		} else {
			return edge.vertex1;
		}
	}

	public static void main(String[] args) {
		int V = 6;
		int E = 9;
		PrimMST mst = new PrimMST(V, E);

		// for(int i=0;i<E;i++) {
		mst.addEdge(0, 1, 3);
		mst.addEdge(0, 3, 1);
		mst.addEdge(1, 2, 1);
		mst.addEdge(1, 3, 3);
		mst.addEdge(2, 4, 5);
		mst.addEdge(2, 5, 4);
		mst.addEdge(3, 2, 1);
		mst.addEdge(3, 4, 6);
		mst.addEdge(4, 5, 2);
		mst.pmst();

	}

}
