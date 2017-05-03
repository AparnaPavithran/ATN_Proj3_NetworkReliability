import java.util.LinkedList;
import java.util.Queue;

public class IsConnected {

	private static Queue<Integer> q; 
	  
	public static boolean bfs(int adjacency_matrix[][], int source,int nodes)
    {
 
		int[] visited = new int[nodes];
        int i, element;
		q = new LinkedList<Integer>();
        visited[source] = 1;
        q.add(source);
        while (!q.isEmpty())
        {
            element = q.remove(); //first element is removed
            i = element; //saved and checks for all others connected with the node.
            while (i < nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    q.add(i);
                    visited[i] = 1; //if it is visited then its marked as 1
                }
                i++;
            }
        }  
        boolean connectivity = false; 
 
        for (int vertex = 0; vertex < nodes; vertex++)
        {
            if (visited[vertex] == 1)
            {
            	connectivity = true;
            } else
            {
            	connectivity = false;
                break;
            }
        }
        return connectivity;
    }
}
