import java.io.*;
import java.util.*;
class Graph
{

	private int V;
	private LinkedList<Integer>adj[];
	Graph(int v)
	{
     V=v;
     adj=new LinkedList[V];
     for(int i=0;i<v;i++)
     	adj[i]=new LinkedList();
	}
	public void addEdge(int src,int dest)
	{
		adj[src].add(dest);
	}
	public void DFS(int src)
	{
		boolean visited[]=new boolean[V];
	    for(int i=0;i<V;i++)
	    {
	    	if(visited[i]==false)
	    	{
	    		DFSUtil(src,visited);
	    	}
           
	    }
	}
	private void DFSUtil(int src,boolean visited[])
	{
		visited[src]=true;
		System.out.print(src+" ");
		Iterator<Integer> i=adj[src].listIterator();
		while(i.hasNext())
		{
			int temp=i.next();
			if(visited[temp]==false)
				DFSUtil(temp,visited);
		}
	}

}
public class Graph_DFS_Recursive
{
	public static void main(String[] args) throws Exception
	{
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enetr the Number of Vertices :");
        int v=Integer.parseInt(inp.readLine());
         Graph g=new Graph (v);
         System.out.println("Enter the Number of Edges :");
         int edge=Integer.parseInt(inp.readLine());
         System.out.println("Enter the Source and Destination");
         for(int i=0;i<edge;i++)
         {
         	String str[]=inp.readLine().trim().split("\\s+");
         	int src=Integer.parseInt(str[0]);
         	int dest=Integer.parseInt(str[1]);
         	g.addEdge(src,dest);
         }
         System.out.println("Enter the Source Node from where u want to run DFS");
         int s=Integer.parseInt(inp.readLine());
         System.out.print("DFS :"+g.DFS(s));
     }
}
	