import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

public class BST <Key extends Comparable<Key>> {
	
	private Key [] keysInOrder;
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    public class Node {
    	Key key;
        Node left, right, parent;
     
        Node(Key key) 
        {
            this.key = key;
            left = right = parent = null;
        }

    }
    public void insert(Key key){
    	root = insert(root, key);

    }
    //taken from code I wrote last year
    public boolean contains(Key key)
    { return contains(root, key); }

    private boolean contains(Node x, Key key) {
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return contains(x.left, key);
        else if (cmp > 0) return contains(x.right, key);
        else              return true;
    }

    private Node insert(Node node, Key key) 
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);
       
        int cmp = key.compareTo(node.key);
		if(cmp<0)
		{
			node.left = insert(node.left, key);
		}
		else if(cmp>0)
		{
			node.right = insert(node.right, key);
		} 
        return node;
    }
 
   
	public Node lca(Node r,Node x, Node y)
	{
		//ensures that both nodes are in the search tree
		if(!this.contains(x.key) || !this.contains(y.key))
		{
			return null;
		}
		if(root==null || x==null || y == null)
	        return null;
	 
	    if(root==x || root==y)
	        return root;
	    
	 
	    Node l = lca(root.left, x, y);
	    Node p = lca(root.right, x, y);
	 
	    if(l!=null&&p!=null)
	    {
	        return root;
	    }
	    else if(l==null&&p==null)
	    {
	        return null;
	    }
	    else
	    {
	        return l==null?p:l;
	    }
	}
}
