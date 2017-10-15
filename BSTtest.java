import static org.junit.Assert.*;

import org.junit.Test;

public class BSTtest {

	
	@Test
	//Test if there are any nodes in the binary search tree yet
	public void testisEmpty(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
						 //         5
		assertFalse("Checking isEmpty of the tree", bst.isEmpty());
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		assertTrue("Checking isEmpty for empty", bst2.isEmpty());
		
	}
	@Test
	//test If node in question is actually in the binary search tree
	//ensure root node has not been selected as it cannot have an
	// ancestor node
	public void testSelection(){
		
	}
	
	
	@Test
	//Test if the function to retrieve a node returns the right value
	public void testGetNode(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
						 //         5
		assertEquals("Checking the get value of the tree", "1", bst.get(1).toString());
		BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
		bst1.put(7, 7);
		assertEquals("Checking the get for only one node", "7", bst1.get(7).toString());
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		assertEquals("Checking the get for empty", null, bst2.get(null));

		BST<Integer, Integer> bst3 = new BST<Integer, Integer>();
		bst3.put(null, null);
		assertEquals("Checking the get funcion for 'null' node", null, bst3.get(null));	  
	}
	
	@Test
	//ensure the returned node is an actual ancestor
	public void testAncestorNode() {
		fail("Not yet implemented");
	}
	
	
	@Test
	//Test if Node is the lowest common ancestor
	public void testIsLowestCommonAncestor(){
		
	}
	

}
