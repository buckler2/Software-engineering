import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



public class LCADag {
	
	private int vertices;           // number of vertices in this digraph
	private int edges;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v
	
	private boolean marked[];		//Boolean List to track visited vertices
	private boolean cycleExists;		//True if cycle in graph
    private boolean stack[];		//Order that vertices were visited

	
	public LCADag(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
	    this.vertices = V;
	    this.edges = 0;
	    indegree = new int[V];
	    marked = new boolean[V];
	    stack = new boolean[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) {
	        adj[v] = new ArrayList<Integer>();
	    }              
	}



}
