import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = adj.size();
        boolean[] isvisited = new boolean[n];
        helper(0, adj, isvisited, list);
        return list;
    }

    public void helper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isvisited, ArrayList<Integer> list) {
        Queue que = new LinkedList();
        isvisited[node] = true;
        que.add(node);
        while (!que.isEmpty()) {
            int a = (int) que.poll();
            list.add(a);
            for (int neighbours : adj.get(a)) {
                if (!isvisited[neighbours]) {
                    que.add(neighbours);
                    isvisited[neighbours] = true;

                }
            }

        }

    }
}
