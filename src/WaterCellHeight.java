import java.util.*;
public class WaterCellHeight
{
    public int[][] highestPeak(int[][] isWater)
    {
        Queue<int[]> que=new LinkedList<>();
        int n=isWater.length;
        int m=isWater[0].length;
        boolean[][] isvisited=new boolean[isWater.length][isWater[0].length];
        int[][] height=new int[n][m];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++)
            {
                if(isWater[i][j]==1)
                {
                    que.offer(new int[]{i,j});
                    isvisited[i][j]=true;
                    height[i][j]=0;
                }
            }
        }
        while(!que.isEmpty())
        {
                int[] arr=que.poll();
                int r=arr[0];
                int c=arr[1];
                int[][] neighbors={{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
                for(int[] neighbor:neighbors)
                {

                    if(neighbor[0]>=0 && neighbor[0]<isWater.length && neighbor[1]>=0 && neighbor[1]<isWater[0].length  &&!isvisited[neighbor[0]][neighbor[1]])

                    {
                        isvisited[neighbor[0]][neighbor[1]]=true;
                        height[neighbor[0]][neighbor[1]] = height[r][c] + 1;
                        que.offer(new int[]{neighbor[0],neighbor[1]});
                    }

                }

        }
        return height;

    }

}
