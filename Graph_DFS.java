import java.io.*;
import java.util.*;
class Graph<T>
{
	HashMap<T,List<T>> map=new HashMap<>();
	private void addVertex(T src)
	{
       map.put(src,new ArrayList<T>());
	}
	public void addEdge(T src,T dest,Boolean birdir)
	{
        if(!map.containsKey(src))
        	addVertex(src);
        if(!map.containsKey(dest))
        	addVertex(dest);

        map.get(src).add(dest);
        if(birdir)
        {
        	map.get(dest).add(src);
        }
	}
	public void Display_Graph()
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
	public void DFS(T src)
	{
       Stack<T> st=new Stack<T>();
       HashMap<T,Boolean>visited=new HashMap<T,Boolean>();
       for(T v:map.keySet())
       {
       	visited.put(v,false);
       }
       st.push(src);
       visited.put(src,true);
       while(!st.isEmpty())
       {
       	  T temp=st.pop();
       	  System.out.print(temp+" ");
       	  for(T nbr:map.get(temp))
       	  {
       	  	if(visited.get(nbr)==false)
       	  	{
       	  		st.push(nbr);
       	  		visited.put(nbr,true);
       	  	}
       	  }
       }

	}
}
public class Graph_DFS
{
	public static void main(String[] args) throws Exception 
	{
           BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
           Graph<Integer> g=new Graph<Integer>();
           System.out.println("Enter the Number of Vertices :");
           int vertices=Integer.parseInt(inp.readLine());
           System.out.println("Enter the Number of Edges :");
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
           g.Display_Graph();
           System.out.println("Enter the Source Node from where U want to run DFS ");
           int s=Integer.parseInt(inp.readLine());
           g.DFS(s);
	}
}