import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges
{
    public int orangesRotting(int[][] grid)
    {
        int n= grid.length;
        int m=grid[0].length;
        int count=0;
        int total=0;
        Queue<int[]> que=new LinkedList<>();
        boolean[][] isvisited=new boolean[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if(grid[i][j]==1)
                {
                    total++;
                }
                else if (grid[i][j]==2 )
                {
                    que.offer(new int[]{i,j});
                    isvisited[i][j]=true;
                }

            }

        }
        while(!que.isEmpty())
        {
            boolean rottedthismin=false;
            int z=que.size();
            for (int i = 0; i < z; i++)
            {
                int[] val=que.poll();
                int row=val[0];
                int col=val[1];



                int[][] neighbors = {{row - 1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1}};
                for (int[] neighbor : neighbors) {
                    if (neighbor[0] >= 0 && neighbor[0] < grid.length && neighbor[1] >= 0 && neighbor[1] < grid[0].length && !isvisited[neighbor[0]][neighbor[1]]&& grid[neighbor[0]][neighbor[1]]==1) {
                        que.offer(new int[]{neighbor[0], neighbor[1]});
                        grid[neighbor[0]][neighbor[1]]=2;
                        isvisited[neighbor[0]][neighbor[1]]=true;
                        total--;
                        rottedthismin=true;

                    }
                }
            }
            if(rottedthismin){
                count++;
            }


        }


        return (total==0)?count:-1;
    }
}
