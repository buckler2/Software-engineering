import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class BSTtest {

	
	@Test 
	public void testInsert(){
		BST<Integer> bst = new BST<Integer>();
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
		BST<Integer> bst = new BST<Integer>();
		bst.insert(7);   //        _7_
		bst.insert(8);   //      /     \
		bst.insert(3);   //    _3_      8
		bst.insert(1);   //  /     \
		bst.insert(2);   // 1       6
		bst.insert(6);   //  \     /
		bst.insert(4);   //   2   4
		bst.insert(5);   //        \
		
		assertEquals("Checking the get value of the tree", true, bst.contains(1));
		BST<Integer> bst1 = new BST<Integer>();
		bst1.insert(7);
		assertEquals("Checking the get for only one root node", true, bst1.contains(7));
		BST<Integer> bst2 = new BST<Integer>();
		assertEquals("Checking the get for empty", false, bst2.contains(null));
		
	}
	
	public void testLowestCommonAncestor(){
		BST<Integer> bst = new BST<Integer>();
		bst.insert(7);   //        _7_
		bst.insert(8);   //      /     \
		bst.insert(3);   //    _3_      8
		bst.insert(1);   //  /     \
		bst.insert(2);   // 1       6
		bst.insert(6);   //  \     /
		bst.insert(4);   //   2   4
		bst.insert(5);   //  
		
		//findLCA();
	//	findLCA()
		
	}
	
	

}
