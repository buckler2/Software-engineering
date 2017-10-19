import java.util.ArrayList;
import java.util.List;


public class BST {

    private Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();// root of BST

    /**
     * Private node class.
     */
    public class Node {
    	int data;
        Node left, right, parent;
     
        Node(int value) 
        {
            data =value;
            left = right = null;
        }

    }
    public void insert(int key){
    	root = insert(root, key);

    }
    //taken from code I wrote last year
    public boolean contains(int key)
    { return contains(root, key); }

    private boolean contains(Node x,  int key) {
        if (x == null) return false;
        int cmp = key - x.data;
        if      (cmp < 0) return contains(x.left, key);
        else if (cmp > 0) return contains(x.right, key);
        else              return true;
    }

    private Node insert(Node node, int key) 
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);
       
        int cmp = key - node.data;
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
 
    int findLowestCommonAncestor(int x, int y) {
    	//clear array list so function can be reused
        path1.clear();
        path2.clear();
        return findLCA(root, x, y);
    }
 
    private int findLCA(Node root, int x, int y) {
 
    	//if root doesnt exist return -1
        if (!findPath(root, x, path1) || !findPath(root, y, path2)) {
            return -1;
        }
 
        int i;
        //iterate through paths until common value found
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
          //  System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
 
	
    //see if a true path exists
    private boolean findPath(Node root, int x, List<Integer> pathToRoot)
    {
        if (root == null) 
        {
            return false;
        }
 
        pathToRoot.add(root.data);
 
        if (root.data == x) 
        {
            return true;
        }
 
        if (root.left != null && findPath(root.left, x, pathToRoot)) 
        {
            return true;
        }
 
        if (root.right != null && findPath(root.right, x, pathToRoot)) 
        {
            return true;
        }
        pathToRoot.remove(pathToRoot.size()-1);
 
        return false;
    }

}
