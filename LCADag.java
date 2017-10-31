import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//edges are the lines that join nodes
//vertexs are the nodes
public class LCADag {
	
	private int edges;;
	private int vertexs;
	
	public class Node{
    	int key;
     
        Node(int value) 
        {
            key =value;
        }
        
        List<Node> parents = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();
        public void addParent(Node x)
        {
        	int i=0;
        	//ensure parent added is not a child of this node as this would
        	// mean a cycle exists
        	while(i < this.children.size())
        	{
        		if(this.children.get(i) == x)
        		{
        			System.out.print("Node x is already a child of this node");
        			return;
        			
        		}
        	}
        	this.parents.add(x);
        }
        public void addChild(Node y)
        {
        	int i =0;
        	//ensure node y is not a parent of this node to ensure no cycle
        	while(i < this.parents.size())
        	{
        		if(y == this.parents.get(i))
        		{
        			System.out.print("Node y is already a parent of this node");
        			return;
        		}
        	}
        	this.children.add(y);
        }
	}

	private int LCA(Node x, Node y){
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
					Node result = xParents.get(i);
					return result.key;
				}
			}
		}
		return -1;
	}	
}
