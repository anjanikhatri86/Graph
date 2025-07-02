import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
     public int findCircleNum(int[][] isConnected)
     {
         //isConnected = [[1,1,0],[1,1,0],[0,0,1]]
         int n= isConnected.length;
         int num=0;
      boolean[] isvisited=new boolean[n];
         for (int i = 0; i < n; i++)
         {
             if(!isvisited[i]) {
                 helper(i, isvisited, isConnected);
                 num++;
             }
         }
         return num;
     }
     public void helper(int node,boolean[] isvisited,int[][] isConnected)
     {
         Queue<Integer> que=new LinkedList();
         isvisited[node]=true;
         que.add(node);

         while(!que.isEmpty()) {
             int a=que.poll();
             for (int i = 0; i < isConnected.length; i++)
               {
                 if(!isvisited[i] && isConnected[a][i]==1)
                 {
                     que.add(i);
                     isvisited[i]=true;
                 }

               }

         }
     }

     public static void main(String[] args) {
         int[][] isConnected = {
                 {1, 0 ,0},
                 {0, 1, 0},
                 {0, 0, 1}
         };
         NumberOfProvinces ob=new NumberOfProvinces();
         System.out.println(ob.findCircleNum(isConnected));
     }

 }
  /**  //BY DFS
    public int findCircleNum(int[][] isConnected) {
        //isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        int n = isConnected.length;
        int num = 0;
        boolean[] isvisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isvisited[i]) {
                helper(i, isvisited, isConnected);
                num++;
            }
        }
        return num;
    }

    public void helper(int node, boolean[] isvisited, int[][] isConnected)
    {
        isvisited[node]=true;
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++)
        {
            if(isConnected[node][neighbour]==1 && !isvisited[neighbour])
            {
                if (isConnected[node][neighbour] == 1 && !isvisited[neighbour]) {
                    helper(neighbour,isvisited,isConnected);
                }
            }

        }
    }
}**/
