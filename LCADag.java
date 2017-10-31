import java.util.ArrayList;
import java.util.Iterator;

public class LCADag {

	private int E; 						//edges are the lines that join nodes
	private int V; 						//vertexs are the nodes
	private ArrayList<Integer>[] adj;   // adj[v] = adjacency list for vertex v
	private int[] indegree;        		// indegree[v] = indegree of vertex v
	private boolean visited[]; 			//Boolean array which checks if a node has been visited yet
	private boolean acyclic = true; 	//If graph has cycle, this is changed to false
	private ArrayList<Integer> firstPath = new ArrayList<Integer>();
	private ArrayList<Integer> secondPath = new ArrayList<Integer>(); //used to find path from root to node in question
	ArrayList<Integer> commonAncestors = new ArrayList<Integer>(); //Common ancestors between two nodes

	//taken from code online https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
	public LCADag(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int E() {
		return E;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}

	/**
	 * Adds the directed edge vw to this digraph.
	 *
	 * @param  v the tail vertex
	 * @param  w the head vertex
	 * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}

	/**
	 * Returns the vertices adjacent from vertex {@code v} in this digraph.
	 *
	 * @param  v the vertex
	 * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	//returns the number of directed going out of the vertex {@code v}.
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	//returns the number of directed edges going into the vertex {@code v}.
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
	/**
	 *I am using a depth first search to test if the graph is acyclic or not
	 *if an already visited node is visted again it means there is a cycle and therefore
	 * the graph is not acyclic
	 */
	//source: http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/

	public ArrayList<Integer> DFS(int v)
	{
		ArrayList<Integer> path = new ArrayList<Integer>();
		DFSutil(v,path);
		return path;
	}
	
	private void DFSutil(int v, ArrayList<Integer> a)
	{
		if(visited[v] == true)
		{
			acyclic = false;
			return;
		}
		// Mark the current node as visited and print it
		visited[v] = true;
		// Recur for all the vertices adjacent to this vertex

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSutil(n,a);
		}

	}

	public int LCA(int p, int r)
	{
		DFS(0);
		if(acyclic == false)
		{
			return -1;
		}
		validateVertex(p);
		validateVertex(r);
		if(E==0)
		{	
			//Graph is empty
			return -1;
		}
		firstPath.clear();
		secondPath.clear();
		commonAncestors.clear();
		LCADag backwards = reverse();
		firstPath= backwards.DFS(p);
		secondPath = backwards.DFS(r);
		boolean found = false;
		for(int i = 0; i<firstPath.size(); i++){
			for(int t = 0; t<secondPath.size(); t++){		
				if(firstPath.get(i)==secondPath.get(t)){
					commonAncestors.add(firstPath.get(i));	
					found = true;
				}
			}
		}

		if(found)
			//Returns first Ancestor in list(LCA)
			return commonAncestors.get(0);
		else
			//No Ancestors found
			return -1;

	}
	//Reverses the Directed Acyclic Graph
	public LCADag reverse() {
		LCADag reverse = new LCADag(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}


}
