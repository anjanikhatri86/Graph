import java.util.ArrayList;
import java.util.List;

public class GraphByList
{
    public class Pair
    {
        int node;
        int weight;
        Pair(int node,int weight)
        {
            this.node=node;
            this.weight=weight;
        }

       @Override
        public String toString()
       {
        return "(" + node +"," + weight+")";
       }
    }
    List<List<Pair>> weightedlist;
    List<List<Integer>> adjlist;
    GraphByList(int nodes)
    {
        adjlist=new ArrayList<>();
        weightedlist=new ArrayList<>();
        for (int i = 0; i < nodes; i++)
        {
            adjlist.add(new ArrayList<>());
            weightedlist.add(new ArrayList<>());
        }
    }
    public void filledges(int[][] edges,boolean isdirected)
    {
    for(int[] edge:edges)
    {
        int u=edge[0];
        int v=edge[1];
        if(isdirected)
        {
            adjlist.get(u).add(v);
        }
        else {
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
    }

    }
    public void weightedList(int[][] edges,boolean isdirected)
    {
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(isdirected)
            {
                Pair pair=new Pair(v,w);
                weightedlist.get(u).add(pair);

            }
            else {
                Pair pair1=new Pair(v,w);
                weightedlist.get(u).add(pair1);
                Pair pair2=new Pair(u,w);
                weightedlist.get(v).add(pair2);
            }
        }
    }
    public void printweightedlist()
    {
        for (int i = 0; i < weightedlist.size(); i++)
        {
            System.out.print("row" +i +"->");
            System.out.println(weightedlist.get(i));
        }
    }

    public void printlist()
    {
     int n=adjlist.size();

        for (int i = 0; i < n; i++)
        {
            System.out.print("row" +i +"->");
            System.out.println(adjlist.get(i));

        }
    }
}
