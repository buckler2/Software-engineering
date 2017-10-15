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
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
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
	
	public boolean containsNode(Node x)
	{
		while(root.)
		
	}
	
	
	public void put(Key key, Value val) {
        if (val == null) { return; } //something missing here
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    // return number of key-value pairs in BST
    public int size() 
    { 
    	return size(root); 
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) 
    {
        if (x == null) return 0;
        else return x.N;
    }
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

	public Node lca(Node x, Node y)
	{
		//first assign lca to root as if all options fail this is the Lca
		Node lowestCommonAncestor = root;
		return; 
	}
	
}
