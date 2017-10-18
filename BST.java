import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> {
	
	private Key [] keysInOrder;
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
    	int key;
        Node left, right, parent;
     
        Node(int key) 
        {
            this.key = key;
            left = right = parent = null;
        }
    }
    

    Node insert(Node node, int key) 
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);
 
        /* Otherwise, recur down the tree */
        if (key < node.key) 
        {
            node.left = insert(node.left, key);
            node.left.parent = node;
        }
        else if (key > node.key) 
        {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
   
	public Node lca(Node r,Node x, Node y)
	{
		Node root;
	    private List<Integer> path1 = new ArrayList<>();
	    private List<Integer> path2 = new ArrayList<>();
	 
	    int findLCA(int n1, int n2) {
	        path1.clear();
	        path2.clear();
	        return findLCAInternal(root, n1, n2);
	    }
	 
	    private int findLCAInternal(Node root, int n1, int n2) {
	 
	 
	    }
	}
}
