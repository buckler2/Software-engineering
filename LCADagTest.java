import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCADagTest {
	
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
	public void testValidateVertex()
	{
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
		assertEquals("vertex is greater than zero and < 16", true ,test.validateVertex(10));
		assertEquals("vertex is less than zero so should be false", false ,test.validateVertex(-10));
		assertEquals("vertex is greater than V so should be false", false ,test.validateVertex(18));
		assertEquals("vertex is equal to V so should be false", false ,test.validateVertex(16));
		
		
	}
	
	@Test
	public void testIterable() {
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		test.addEdge(6, 16);
		test.addEdge(5, 7);
		
		//test
		//ensure adjancy is working correctly
		String ans = "[5, 6, 11]";
		assertEquals("",ans, test.adj(4).toString());	
		assertEquals("Should return null as vertex out of range",null, test.adj(77));
	}
	
	@Test
	public void testOutDegree() {
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		//tests
		assertEquals("Should return 2 for vertex 0",2, test.outdegree(0));
		assertEquals("Should return -1 as vertex out of range",-1, test.outdegree(-3));
		
	}
	
	@Test
	public void testInDegree() {
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		//tests
		assertEquals("Should return 2 for vertex 3",2, test.indegree(3));
		assertEquals("Should return -1 as vertex out of range",-1, test.indegree(-11));
		
	}
	
	@Test
	public void testDFS(){
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		
		//Test
		String ans = "[0, 1, 2, 3, 4, 5]";
		assertEquals("",ans,test.DFS(0).toString());

		
	}
	
	@Test
	public void testLCA(){
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		//Test
		assertEquals("", 0, test.LCA(3,1));
		assertEquals("", 4, test.LCA(6,11));
		
		//For out of bound vertex
		assertEquals("", -1, test.LCA(18,11));
		
		//For cyclical graph 
		LCADag test2 = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(3, 0);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		assertEquals("cyclical graph returns -1",-1, test2.LCA(4, 11));
		
	}
	
	@Test
	public void testReverse(){
		LCADag test = new LCADag(16);
		test.addEdge(0, 1);
		test.addEdge(0, 3);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		test.addEdge(4, 11);
		
		LCADag reverse = test.reverse();
		assertEquals("The out degree of vertex 4 should change from 3 to 1", 1,reverse.outdegree(4));
		assertEquals("The indegree of vertex 3 should change from 2 to 1", 1,reverse.indegree(3));
	}

}
