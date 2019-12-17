package coding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents_with_KosarajuAlgo {
	
	static class Graph {
		int V;
		LinkedList<Integer> adjList[];
		Graph(int V) {
			this.V = V;
			adjList = new LinkedList[V];
			for(int i = 0 ; i < V ; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int src, int dest) {
			adjList[src].add(dest);
		}
	}
	
	static Graph getTranspose(Graph g) {
		Graph g2 = new Graph(g.V);
		for(int i = 0 ; i < g.V ; i++) {
			Iterator<Integer> it = g.adjList[i].iterator();
			while(it.hasNext()) {
				int num = it.next();
				g2.addEdge(num, i);
			}
		}
		return g2;
	}
	
	public static void fillOrder(Graph g, int val, boolean[] vis, Stack stack) {
		vis[val] = true;
		Iterator<Integer> i = g.adjList[val].iterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!vis[num]) {
				fillOrder(g, num, vis, stack);
			}
		}
		stack.push(new Integer(val));
	}
	
	public static void DFSUtil(Graph g, int val, boolean[] vis) {
		vis[val] = true;
		System.out.print(val + " ");
		Iterator<Integer> i = g.adjList[val].iterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!vis[num]) {
				DFSUtil(g, num, vis);
			}
		}
	}
	
	public static void printSCC(Graph g) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean vis[] = new boolean[g.V];
		for(int i = 0 ; i < g.V ; i++) {
			if(!vis[i]) {
				fillOrder(g, i, vis, stack);
			}
		}
		
		Graph gr = getTranspose(g);
		for(int i = 0 ; i < g.V ; i++) {
			vis[i] = false;
		}
		
		while(!stack.isEmpty()) {
			int val = stack.pop();
			if(!vis[val]) {
				DFSUtil(gr, val, vis);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		
		printSCC(g);
	}

}*/



public class StronglyConnectedComponents_with_KosarajuAlgo {
	
	static class Graph {
		int V;
		LinkedList<Integer> adjList[];
		Graph(int V) {
			this.V = V;
			adjList = new LinkedList[V];
			for(int i = 0 ; i < V ; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int src, int dest) {
			adjList[src].add(dest);
		}
	}
	
	public static void fillInOrder(Graph g, int val, boolean []visited, Stack st) {
		visited[val] = true;
		Iterator<Integer> i = g.adjList[val].iterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!visited[num]) {
				fillInOrder(g, num, visited, st);
			}
		}
		st.push(new Integer(val));
	}
	
	public static void DFSUtil(Graph g, boolean[] visited, int val) {
		System.out.print(val + " ");
		visited[val] = true;
		Iterator<Integer> i = g.adjList[val].iterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!visited[num])
				DFSUtil(g, visited, num);
		}
	}
	
	public static Graph getTranspose(Graph g) {
		Graph g1 = new Graph(g.V);
		for(int i = 0 ; i < g.V ; i++) {
			Iterator<Integer> it = g.adjList[i].iterator();
			while(it.hasNext()) {
				int num = it.next();
				g1.addEdge(num, i);
			}
		}
		return g1;
	}
	
	public static void printSCC(Graph g) {
		boolean[] visited = new boolean[g.V];
		Stack stack = new Stack();
		for(int i = 0 ; i < g.V ; i++) {
			if(!visited[i]) {
				fillInOrder(g, i, visited, stack);
			}
		}
		
		for(int i = 0 ; i < g.V ; i++) {
			visited[i] = false;
		}
		
		Graph gr = getTranspose(g);
		
		while(!stack.isEmpty()) {
			int num = (Integer) stack.pop();
			if(!visited[num]) {
				DFSUtil(gr, visited, num);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(3, 4);
		
		printSCC(g);
	}
}
