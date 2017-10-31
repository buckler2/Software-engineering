import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LCADag {
	
	public class Node{
    	int data;
     
        Node(int value) 
        {
            data =value;
        }
        
        List<Node> parents = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();
        public void addParent(Node x)
        {
        	this.parents.add(x);
        }
        public void addChild(Node y)
        {
        	this.children.add(y);
        }
	}
	
	public int LCA(Node x, Node y){
		List<Node> xParents = x.parents;
		List<Node> yParents = y.parents;
		
		int i = xParents.size();
		int j = yParents.size();
		for(; i >=0 ; i--)
		{
			for(; j>=0; i--)
			{
				if(xParents.get(i) == xParents.get(j))
				{
					
				}
			}
		}
		return -1;
	}
	

}
