import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            // Code here
            ArrayList<Integer> list = new ArrayList<>();
            int n = adj.size();
            boolean[] isvisited = new boolean[n];

            helper(0, adj, isvisited,list);

            return list;
        }
        public void helper(int node,ArrayList<ArrayList<Integer>> adj,boolean[] isvisited,ArrayList<Integer> list)
        {
            isvisited[node]=true;
            list.add(node);
            for(int neighbours:adj.get(node))
            {
                if(!isvisited[neighbours])
                {
                    helper(neighbours, adj, isvisited, list);
                }
            }
        }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(2, 3, 1)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(2))
                )
        );
        DFS obj=new DFS();
        obj.dfs(adj);

    }

}