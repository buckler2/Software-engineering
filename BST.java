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
		if(root==null || x==null || y == null)
	        return null;
	 
	    if(root==x || root==y)
	        return root;
	    
	 
	    Node l = lca(root.left, x, y);
	    Node p = lca(root.right, x, y);
	 
	    if(l!=null&&r!=null)
	    {
	        return root;
	    }else if(l==null&&r==null)
	    {
	        return null;
	    }else
	    {
	        return l==null?r:l;
	    }
	}
}
