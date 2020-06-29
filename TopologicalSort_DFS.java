import java.io.*;
import java.util.*;
class Graph<T>
{
	HashMap<T,List<T>>map=new HashMap();
	private void addVertex(T src)
	{
      map.put(src,new ArrayList<T>());
	}
	public void addEdge(T src,T dest)
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
	public void Topological_Sort()
	{ 
            HashMap<T,Boolean> visited=new HashMap<T,Boolean>();
            for(T v:map.keySet())
            {
            	visited.put(v,false);
            }
            Stack<T> stack=new Stack<T>();
            for(T v:map.keySet())
            {
            	if(visited.get(v)==false)
            	  TopologicalUtil(v,visited,stack);
            }
            while(!stack.isEmpty())
           {
           	System.out.print(stack.pop()+" ");
           }
	}
	private void TopologicalUtil(T src,HashMap<T,Boolean>visited,Stack<T> stack)
	{
          visited.put(src,true);
          for(T nbr:map.get(src))
          {
          	if(visited.get(nbr)==false)
          	{
          		TopologicalUtil(nbr,visited,stack);
          	}
          }
          stack.push(src); // after visiting all vertices .. we push node in the stack 
	}
}
public class TopologicalSort_DFS
{
	public static void main(String [] args) throws Exception 
	{
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enetr the Number of Vertices :");
        int v=Integer.parseInt(inp.readLine());
         Graph<Integer> g=new Graph<Integer>();
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
         System.out.println("Adjacency List Representation :");
         g.DisplayGraph();
         System.out.println("Topological Sort :");
         g.Topological_Sort();
	}
}