public class FloodFill
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        dfs( image, sr , sc, image[sr][sc], color);
        return image;

    }
    public void dfs(int[][] image,int row ,int col,int currentcolor,int newcolor)
    {
        if(row<0 || row>=image.length || col<0 || col>=image[0].length )
        {
            return;
        }
        if(image[row][col]!=currentcolor)
        {
            return;
        }
        if(image[row][col]==newcolor)
        {
            return;
        }
        image[row][col]=newcolor;
        int[][] neighbors={{row-1,col},{row+1,col},{row,col-1},{row,col+1}};
        for(int[] neighbor:neighbors)
        {
            dfs( image, neighbor[0] , neighbor[1], currentcolor, newcolor);
        }
    }
}
