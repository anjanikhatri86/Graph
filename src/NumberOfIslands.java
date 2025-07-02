public class NumberOfIslands
{
    public int numIslands(char[][] grid)
    {
        int count=0;
        int n= grid.length;
        int m=grid[0].length;
        boolean[][] isvisited=new boolean[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++) {
                if(!isvisited[i][j] && grid[i][j] == '1')
                {
                    dfs(i,j,grid,isvisited);
                    count++;
                }
            }


        }
        return count;

    }
    public void dfs(int row,int col,char[][] grid,boolean[][] isvisited)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length )
        {
            return;
        }
        if(grid[row][col]=='0')
        {
            return;
        }

        if(isvisited[row][col])
        {
            return;
        }

        isvisited[row][col]=true;
        int[][] neighbors={{row-1,col},{row+1,col},{row,col-1},{row,col+1}};
        for(int[] neighbor:neighbors)
        {
            dfs(neighbor[0],neighbor[1], grid,isvisited);


        }


    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberOfIslands  obj=new NumberOfIslands();
        obj.numIslands(grid);
    }

}
