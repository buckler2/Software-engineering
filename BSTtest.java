import static org.junit.Assert.*;
import org.junit.Test;

public class BSTtest {

	
	@Test 
	public void testInsert(){
		BST bst = new BST();
		bst.insert(7);   //        _7_
		bst.insert(8);   //      /     \
		bst.insert(3);   //    _3_      8
		bst.insert(1);   //  /     \
		bst.insert(2);   // 1       6
		bst.insert(6);   //  \     /
		bst.insert(4);   //   2   4
		bst.insert(5);   //        \
		
		assertTrue("Checking the insert value of the tree", (bst.contains(7)));
		assertTrue("Checking the insert value of the tree", bst.contains(5));
		assertFalse("Checking the insert value of the tree",bst.contains(51));
	}
	
	@Test
	public void testContains(){
		BST bst = new BST();
		bst.insert(7);   //        _7_
		bst.insert(8);   //      /     \
		bst.insert(3);   //    _3_      8
		bst.insert(1);   //  /     \
		bst.insert(2);   // 1       6
		bst.insert(6);   //  \     /
		bst.insert(4);   //   2   4
		bst.insert(5);
		//        \
		//test1
		assertEquals("Checking if contains returns true for a node when it is in the tree", true, bst.contains(1));
		//test2
		assertEquals("Checking if contains returns false when the root is not in tree", false, bst.contains(11));
		BST bst1 = new BST();
		bst1.insert(7);
		//test 3
		assertEquals("Checking contains for only one root node", true, bst1.contains(7));
		BST bst2 = new BST();
		//test 4
		assertEquals("Checking contains for empty tree", false, bst2.contains(0));
		
		
	}
	
	@Test
	public void testLowestCommonAncestor(){
		BST bst = new BST();
		bst.insert(7);   //        _7_
		bst.insert(8);   //      /     \
		bst.insert(3);   //    _3_      8
		bst.insert(1);   //  /     \
		bst.insert(2);   // 1       6
		bst.insert(6);   //  \     /
		bst.insert(4);   //   2   4
		bst.insert(5);   //  
		
		//test1
		assertEquals("Checking if LCA finds correct parent", 3, bst.findLowestCommonAncestor(2, 4));
		//test2
		assertEquals("Checking if LCA finds correct parent when root is ancestor", 7, bst.findLowestCommonAncestor(4,8));
		//test3
		assertEquals("Checking if LCA returns -1 when node entered is not in tree", -1, bst.findLowestCommonAncestor(11,8));
		//test4 
		assertEquals("checking that the root is returned when finding ancestor between root and "
				+ "other node", 7, bst.findLowestCommonAncestor(7,8));
	}
	

}