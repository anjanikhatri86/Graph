import java.util.Scanner;

 class Graph
{
    int[][] adjmatix;

    Graph(int nodes)
    {
        //creating n*n matrix with every element zero
        adjmatix=new int[nodes][nodes];
    }
    public void filledges(int[][] edges,boolean isdirected)
    {
        for(int edge=0;edge<edges.length;edge++)
        {
            int u=edges[edge][0];
            int v=edges[edge][1];
            if(isdirected)
            {
                //directed
                adjmatix[u][v]=1;
            }else
            {
                //undirected
                adjmatix[u][v]=1;
                adjmatix[v][u]=1;
            }
        }

    }
    public void filledgesweight(int[][] edges,boolean isdirected)
    {
        for(int edge=0;edge<edges.length;edge++)
        {
            int u=edges[edge][0];
            int v=edges[edge][1];
            int w=edges[edge][2];
            if(isdirected)
            {
                //directed
                adjmatix[u][v]=w;
            }else
            {
                //undirected
                adjmatix[u][v]=w;
                adjmatix[v][u]=w;
            }
        }

    }

    public void printmatrix()
    {
        int n= adjmatix.length;
        for (int i = 0; i < n; i++)
        {
            System.out.print("row" +i +" ->");
            for (int j = 0; j < n; j++)
            {

                System.out.print(adjmatix[i][j] + "  ");
            }
            System.out.println();

        }
    }



}
