import java.util.LinkedList;
import java.util.Queue;

public class FFbfs
{

    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        Queue<int[]> que =new LinkedList<>();
        int currentcolor=image[sr][sc];
        que.offer(new int []{sr,sc});
        while(!que.isEmpty())
        {
            int[] element=que.poll();
            int row=element[0];
            int col=element[1];

            image[row][col]=color;
            int[][] neighbors={{row-1,col},{row+1,col},{row,col-1},{row,col+1}};
            for(int[] neighbor:neighbors)
            {
                if(neighbor[0]<0 || neighbor[0]>=image.length || neighbor[1]<0 || neighbor[1]>=image[0].length  ||image[neighbor[0]][neighbor[1]]!=currentcolor||image[neighbor[0]][neighbor[1]]==color)

                {
                    continue;
                }
                que.offer(new int[] {neighbor[0],neighbor[1]});

            }

        }

        return image;

    }
}
