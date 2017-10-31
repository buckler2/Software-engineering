import static org.junit.Assert.*;

import org.junit.Test;

public class LCADagTest {

	//Test the directed graph object I created works properly
	@Test
	public void LCADag() {
		LCADag test = new LCADag(15);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		
		assertEquals("There should be only 1 indegree for vertex 4", 1, test.indegree(4));
		assertEquals("There should be no 0 indegrees for 7",0,test.indegree(7));
		assertEquals("There should be 1 outdegree for vertex 3", 1, test.outdegree(3));
		assertEquals("There should be 3 outdegres for vertex 4", 3, test.outdegree(4));
		assertEquals("Number of edges should be 8", 8, test.E());
		assertEquals("Number of vertices should be 10", 15, test.V());
		
		//ensure adjancy is working correctly
		String ans = "[5, 6, 11]";
		assertEquals("",ans, test.adj(4).toString());
		
		//For empty directed graph		
		
	}
	
	//ensure function returns correct number of vertices
	@Test
	public void testV() {
		LCADag test = new LCADag(16);
		//test
		assertEquals("V function should return 16", 16, test.V());
		LCADag test2 = new LCADag(0);
		//test for empty graph
		assertEquals("V function should return 0", 0, test2.V());
	}
	
	@Test
	public void testE() {
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		//test
		assertEquals("E function should return 8", 8, test.E());
		
		//test2 for empty
		LCADag test2 = new LCADag(0);
		assertEquals("E function should return 0", 0, test2	.E());
	}
	

	@Test(expected=Exception.class)
	public void exceptionTest(){
		//Can't make a directed graph with less than 0 vertices
		new LCADag(-1);
	}
	
	@Test
	public void testAddEdge(){
		LCADag test = new LCADag(20);
		
		test.addEdge(0, 4);
		test.addEdge(1, 2);
		
		//These functions should not add any edges as they do not fit constraints of directed graph
		// i.e 25> V & -1<V
		test.addEdge(3, 25);
		test.addEdge(-1, 4);
		
		assertEquals("E function should return 2",2,test.E());
	}
	
	
	
	@Test
	public void testIterable() {
		
	}
	
	@Test
	public void testOutDegree() {
		
	}
	
	@Test
	public void testInDegree() {
		
	}
	
	@Test
	public void testDFS(){
		
	}
	
	@Test
	public void testLCA(){
		
	}
	
	@Test
	public void testReverse(){
		
	}

}
