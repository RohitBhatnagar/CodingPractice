package coding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GraphImpl {

	static class Graph {
		int V;
		LinkedList<Integer> adjList[];
		Graph(int V) {
			this.V = V;
			adjList = new LinkedList[V];
			for(int i = 0 ; i < V ; i++) {
				adjList[i] = new LinkedList();
			}
		}
	}
	
	static void addEdge(Graph g, int src, int dest) {
		g.adjList[src].add(dest);
		g.adjList[dest].add(src);
	}
	
	static void printGraph(Graph g) {
		for(int i = 0 ; i < g.V ; i++) {
			System.out.println(i + " -> " + g.adjList[i]);
		}
	}
	
	static class GraphMatrix {
		int V;
		int[][] adjMatrix;
		GraphMatrix(int V) {
			this.V = V;
			adjMatrix = new int[V][V];
			for(int i = 0 ; i < V ; i++) {
				for(int j = 0 ; j < V ; j++) {
					adjMatrix[i][j] = 0;
				}
			}
		}
	}
	
	static void addEdge_inMatrix(GraphMatrix g, int src, int dest) {
		g.adjMatrix[src][dest] = 1;
		g.adjMatrix[dest][src] = 1;
	}
	
	static void printgraphMatrix(GraphMatrix g) {
		for(int i = 0 ; i < g.V ; i++) {
			System.out.print(i + " -> ");
			for(int j = 0 ; j < g.V ; j++) {
				System.out.print(g.adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	} 
	
	public static void BFS(Graph g, int val) {
		boolean visited[] = new boolean[g.V];
		visited[val] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(val);
		while(!queue.isEmpty()) {
			int res = queue.poll();
			System.out.print(res + " ");
			Iterator<Integer> i = g.adjList[res].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	// It's better to use recursion in a DFS, since we need to backtrack once our
	// container is empty
	public static void DFS(Graph g, int val) {
		boolean visited[] = new boolean[g.V];
		DFSUtil(g, val, visited);
	}
	
	public static void DFSUtil(Graph g, int val, boolean[] visited) {
		visited[val] = true;
		System.out.print(val + " ");
		Iterator<Integer> i = g.adjList[val].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(g, n, visited);
			}
		}
	}
	
	public static void DFSIterative(Graph g, int val) {
		boolean visited[] = new boolean[g.V];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(val);
		while(!stack.isEmpty()) {
			int num = stack.peek();
			stack.pop();
			if(!visited[num]) {
				System.out.print(num + " ");
				visited[num] = true;
			}
			Iterator<Integer> i = g.adjList[num].iterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					stack.push(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Graph g = new Graph(num);
		addEdge(g, 0, 1);
		addEdge(g, 1, 2);
		addEdge(g, 2, 3);
		addEdge(g, 3, 4);
		addEdge(g, 4, 0);
		printGraph(g);
		
		GraphMatrix g1 = new GraphMatrix(num);
		addEdge_inMatrix(g1, 0, 1);
		addEdge_inMatrix(g1, 1, 2);
		addEdge_inMatrix(g1, 2, 3);
		addEdge_inMatrix(g1, 3, 4);
		addEdge_inMatrix(g1, 4, 0);
		printgraphMatrix(g1);
		
		BFS(g, 2);
		System.out.println();
		DFS(g, 3);
		System.out.println();
		DFSIterative(g, 3);
		sc.close();
	}
	
}