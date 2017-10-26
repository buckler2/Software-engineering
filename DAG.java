
import java.util.List;

public class DAG {
	
   Node root; // assuming only one root exists

   public static class Node{
      List<Node> successors;
      int value; 
   }
}