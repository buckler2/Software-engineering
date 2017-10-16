import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	
	private Key [] keysInOrder;
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    
	public boolean isEmpty()
	{
		if(this.root == null)
		{
			return true;
		}
		return false;
	}
	

	
	public void put(Key key, Value val) {
        if (val == null) { return; } //something missing here
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        return x;
    }
   
	public Node lca(Node r,Node x, Node y)
	{
		//first assign lca to root as if all options fail this is the Lca
		Node lowestCommonAncestor = root;
		r = root;
		
		 if(isEmpty())
		 {
			 return null; 
		 }
		 if(root== x || root==y)
		 {
			 return root;
		 }
		 
		 Node p = lca(root.left, x, y);
		 Node w = lca(root.right, x, y);
		 
		    if(p!=null && w!=null){
		        return root;
		    }
		    else if
		    (p==null && w==null)
		    {
		    	lowestCommonAncestor = null;
		    }
		    else
		    {
		    	lowestCommonAncestor = p==null?w:p;
		    } 
		    return lowestCommonAncestor;
	}
	
}
