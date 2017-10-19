import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		bst.insert(5);   //        \
		
		assertEquals("Checking the get value of the tree", true, bst.contains(1));
		BST bst1 = new BST();
		bst1.insert(7);
		assertEquals("Checking the get for only one root node", true, bst1.contains(7));
		BST bst2 = new BST();
		assertEquals("Checking the get for empty", false, bst2.contains(0));
		
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
		assertEquals("Checking if LCA finds correct parent", 7, bst.findLowestCommonAncestor(4,8));
		//test3
		assertEquals("Checking if LCA returns -1 when node entered is not in tree", -1, bst.findLowestCommonAncestor(11,8));
		
		
	}
	

}
