import static org.junit.Assert.*;

import org.junit.Test;

public class BSTtest {

	
	@Test 
	public void testInsert(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.insert(7, 7);   //        _7_
		bst.insert(8, 8);   //      /     \
		bst.insert(3, 3);   //    _3_      8
		bst.insert(1, 1);   //  /     \
		bst.insert(2, 2);   // 1       6
		bst.insert(6, 6);   //  \     /
		bst.insert(4, 4);   //   2   4
		bst.insert(5, 5);   //        \
						 /
		assertTrue("Checking the put value of the tree", bst.contains(7));
		assertFalse("Checking the put value of the tree", bst.contains(4));
	}
	
	public void testLowestCommonAncestor(){
		bst.insert(7, 7);   //        _7_
		bst.insert(8, 8);   //      /     \
		bst.insert(3, 3);   //    _3_      8
		bst.insert(1, 1);   //  /     \
		bst.insert(2, 2);   // 1       6
		bst.insert(6, 6);   //  \     /
		bst.insert(4, 4);   //   2   4
		bst.insert(5, 5);   //  
		
		findLCA();
		findLCA()
		
	}
	
	

}
