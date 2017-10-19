import java.util.ArrayList;
import java.util.List;


public class BST <Key extends Comparable<Key>> {

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
 
	public int lowestCommonAncestor(Key x, Key y){
		
		//if one key is not in binary tree, -1 is returned
		if(!contains(x) || !(contains(y)))
		{
			return -1;
		}
		//create 2 lists which will be compared against eachother to find common ancestor
		ArrayList<Integer> line1 = new ArrayList<>();
		ArrayList<Integer> line2 = new ArrayList<>();
		
		//Add path of nodes to each key to allow for comparison of common ancestor
		line1 = findPath(x);
		line2 = findPath(y);
		
		for(int count = 0; count < line1.size() && count < line2.size(); count++){
			
			if(line1.get(count).equals(line2.get(count))){
				return line1.get(count);
			}
		}
		//Return -1 if no ancestor
		return -1;
	}
	
	public List<Integer> printPath(Key x){
	    ArrayList<Integer> path = new ArrayList<>();
	    return path; 
	}

}
