import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCADag {
	//edge is an ordered pair of nodes
    public class Node {
    	int data;
        private List<Node> parents = new ArrayList<>();
        private List<Node> successors = new ArrayList<>();
     
        Node(int value) 
        {
            data = value;
        }
    }
    
     private class PathMap {
    	  HashMap<LCADag.Node, List<LCADag.Node> > pathMap;
    	  public List<LCADag.Node> getPathFromRoot(LCADag.Node n) {
    	     List<LCADag.Node> pathFromRoot = pathMap.get(n);
    	     return pathFromRoot;
    	  }
    	}

}
