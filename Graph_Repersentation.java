/* Graph can be represented in two ways:-
1.Adjency Matrix:
It is good to determine whether a edge exist between two nodes
Space complexity is O(v^2)
To know if two nodes are connected:O(1)
To know the neighbors of a node O(V)
This type of representation is good for dense graph. For sparse graph we waste a lot of space
Adding a new vertex takes O(1) time
2.Adjency List
It is good in term of space its space complexity is O(V+E)
to know if two node are connected O(V)
to know the neighbors the complexit is O(v)
adding a new node take O(V).
*/
import java.io.*;
import java.util.*;
class Graph<T>
{
	HashMap<T,List<T>>map=new HashMap<>();
	private void addVertex(T src)
	{
      map.put(src,new ArrayList<T>());
	}
	public void addEdge(T src,T dest,boolean bidir)
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
		if(bidir==true) // If we have bidirectonal edge 
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
	public void Count_Vertex()
	{
        System.out.println("The No. of Vertex Present in the Graph is :"+map.keySet().size());
	}
	public void Edge_Count(boolean birdir)
	{
        int count=0;
        for(T v:map.keySet())
        {
        	count+=map.get(v).size();
        }
        if(birdir)
        {
        	System.out.println("The no. of edges Present in the grpah is :"+count/2);
        }
        else
        {
        	System.out.println("The no. of Edges Present in the Graph is :"+count);
        }
	}
	public boolean has_Vertex(T v)
	{
         if(map.containsKey(v))
         {
         	System.out.println("Graph contains the vertex "+v);
         	return true;
         }
         else
         {
         	System.out.println("Graph doesn't contains the vertex "+v);
         	return false;
         }
	}
	public boolean has_Edge(T src,T dest)
	{
          if(map.get(src).contains(dest))
          {
          	System.out.println("Graph Contains Edge Between "+src+" "+dest);
          	return true;
          }
          else
          {
          	System.out.println("Graph doesn't Contains any Edge Between "+src+" "+dest);
          	return false;
          }
	}
}
public class Graph_Repersentation
{
	public static void main(String[] args) throws Exception
	{
       BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
       Graph<Integer> g=new Graph<Integer>();
       System.out.println("Enter the No. of Vertex");
       int vertices=Integer.parseInt(inp.readLine());
       System.out.println("Enter the No. of Edges");
       int edges=Integer.parseInt(inp.readLine());
       int [][] matrix=new int[vertices+1][vertices+1];
       System.out.println("Enter the Source and Destinations");
       for(int i=0;i<edges;i++)
       {
       	  String line=inp.readLine(); // for taking input in one line 
       	  String str[]=line.trim().split(" ");
       	   int src=Integer.parseInt(str[0]);
       	   int dest=Integer.parseInt(str[1]);
       	   matrix[src-1][dest-1]=1; //adjacency matrix Representation 
           g.addEdge(src,dest,true);
       }
       System.out.println("Adjacency List Repersentation :"); 
       g.Display_Graph();

       System.out.println("Adjacency Matrix Repersentation :");
       for(int i=0;i<vertices;i++)
       {
       	for(int j=0;j<vertices;j++)
       	{
       		System.out.print(matrix[i][j]+" ");
       	}
       	System.out.println();
       }
       g.Count_Vertex();
       g.Edge_Count(true);
       g.has_Vertex(2);
       g.has_Vertex(6);
       g.has_Edge(1,3);
       g.has_Edge(1,4);

	}
}