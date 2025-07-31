import java.util.LinkedList;
import java.util.Queue;

public class SurroundingRegions
{
    public void solve(char[][] board)
    {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(0,i,board);
            }
            if(board[n-1][i]=='O')
            {
                dfs(n-1,i,board);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(i,0,board);
            }
            if(board[i][m-1]=='O')
            {
                dfs(i,m-1,board);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='B') board[i][j]='O';
            }
        }

    }
    public void dfs(int row,int col,char[][] board)
    {
        int n=board.length;
        int m=board[0].length;
        if(row<0 || row>n-1 ||col<0 ||col>m-1 || board[row][col]!='O')
        {
            return;
        }
        board[row][col]='B';
        dfs(row-1,col,board);
        dfs(row+1,col,board);
        dfs(row,col-1,board);
        dfs(row,col+1,board);

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X'}
        };

        SurroundingRegions ob=new SurroundingRegions();
        ob.solve(board);
    }
}
