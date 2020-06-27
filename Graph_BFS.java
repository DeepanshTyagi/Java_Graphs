import java.io.*;
import java.util.*;
class Graph<T>
{
	HashMap<T,List<T>>map=new HashMap<>();
	private void addVertex(T src)
	{
        map.put(src,new ArrayList<>());
	}
	public void addEdge(T src,T dest,boolean birdir)
	{
     if(!map.containsKey(src))
     {
     	addVertex(src);
     }
     if(!map.containsKey(dest))
     {
     	addVertex(dest);
     }
     map.get(src).add(dest);
     if(birdir)
     {
     	map.get(dest).add(src);
     }
	}
   public void DisplayGraph()
   {
   	for(T v:map.keySet())
   	{
   		System.out.print(v+" --> ");
   		for(T nbr:map.get(v))
   		{
   			System.out.print(nbr+" ");
   		}
   		System.out.println();
   	}
   }
   public void BFS(T src)
   {
   	Queue<T> queue=new LinkedList<T>();
   	HashMap<T,Boolean>visited=new HashMap<T,Boolean>();
   	for(T v:map.keySet())
   	{
   		visited.put(v,false);
   	}
   	visited.put(src,true);
   	queue.add(src);
   	while(!queue.isEmpty())
   	{
   		T peek=queue.poll();
   		System.out.print(peek+" ");
   		for(T nbr:map.get(peek))
   		{
           if(visited.get(nbr)==false)
           {
           	queue.add(nbr);
           	visited.put(nbr,true);
           }
   		}
   	}
   }
}
public class Graph_BFS
{
	public static void main(String[] args) throws Exception
	{
      BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
      Graph<Integer> g=new Graph<Integer>();
      System.out.println("Enter the Number of Vertices");
      int vertices=Integer.parseInt(inp.readLine());
      System.out.println("Enter the Number of Edges");
      int edges=Integer.parseInt(inp.readLine());
      System.out.println("Enter the Source and Destination :");
      for(int i=0;i<edges;i++)
      {
      	String line=inp.readLine();
      	String[] str=line.trim().split(" ");
        int src=Integer.parseInt(str[0]);
        int dest=Integer.parseInt(str[1]);
        g.addEdge(src,dest,true);
      }
      g.DisplayGraph();
      System.out.println("Enter the Source Node for BFS");
      int s=Integer.parseInt(inp.readLine());
      g.BFS(s);
	}
}