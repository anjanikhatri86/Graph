public class NumberOfEnclaves
{
    public int numEnclaves(int[][] grid)
    {
        int count=0;
        int n=grid.length;

        int m=grid[0].length;
        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==1) dfs(0,i,grid);
            if(grid[n-1][i]==1)dfs(n-1,i,grid);
        }
        for(int j=0;j<n;j++)
        {
            if(grid[j][0]==1) dfs(j,0,grid);
            if(grid[j][m-1]==1) dfs(j,m-1,grid);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1) count++;
            }
        }
        return count;


    }
    public void dfs(int row,int col,int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        if(row<0|| row>n-1||col<0||col>m-1|| grid[row][col]!=1)
        {
            return;
        }
        grid[row][col]=2;
        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col-1,grid);
        dfs(row,col+1,grid);
    }
}
