package coding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Counting_num_of_trees {
	
	static class Graph {
		int V;
		LinkedList<Integer> adjList[];
		Graph(int V) {
			this.V = V;
			this.adjList = new LinkedList[V];
			for(int i = 0 ; i < V ; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
	}
	
	public static void addEdge(Graph g, int src, int dest) {
		g.adjList[src].add(dest);
	}
	
	public static void DFS(Graph g, boolean[] vis, int val) {
		vis[val] = true;
		Iterator<Integer> i = g.adjList[val].iterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!vis[num]) {
				DFS(g, vis, num);
			}
		}
	}
	
	public static void countNumOfTrees(Graph g) {
		boolean visited[] = new boolean[g.V];
		int count = 0;
		for(int i = 0 ; i < g.V ; i++) {
			if(!visited[i]) {
				DFS(g, visited, i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Graph g = new Graph(num);
		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 3, 4);
		countNumOfTrees(g);
		sc.close();
	}
}
