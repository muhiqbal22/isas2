/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map_project;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ahmed
 */
public class Graph {
   	 int MAXSIZE  = 51;
	    int adj[][]  = new int[MAXSIZE][MAXSIZE];
	    int visited[]  = new int[MAXSIZE];
	    Stack s  = new Stack();
	   public Node graph[] = new Node[MAXSIZE]; 
	    Stack createGraph(String technique,int source,int goal){
	    	graph[0] = new Node("Tala",1,435,55);
	    	graph[1] = new Node("B_s",2,560,120);
	    	graph[2] = new Node("shoh",3,400,150);
	    	graph[3] = new Node("shbeen",4,480,200);
	    	graph[4] = new Node("Qesna",5,600,215);
	    	graph[5] = new Node("menof",6,419,285);
	    	graph[6] = new Node("s_el",7,450,304);
	    	graph[7] = new Node("bagour",8,509,327);
	    	graph[8] = new Node("Ashmoon",9,460,457);
	    	graph[9] = new Node("Sadat",10,62,405);
	    	//create neighbors
	    	graph[0].neighbors = new Node[] {graph[1],graph[2],graph[3]};
	    	graph[1].neighbors = new Node[] {graph[0],graph[3],graph[4]};
	    	graph[2].neighbors = new Node[] {graph[0],graph[5]};
	    	graph[3].neighbors = new Node[] {graph[0],graph[1],graph[4],graph[5]};
	    	graph[4].neighbors = new Node[] {graph[1],graph[3],graph[7]};
	    	graph[5].neighbors = new Node[] {graph[2],graph[3],graph[8],graph[9]};
	    	graph[6].neighbors = new Node[] {graph[5],graph[7],graph[9]};
	    	graph[7].neighbors = new Node[] {graph[4],graph[6],graph[8]};
	    	graph[8].neighbors = new Node[] {graph[7],graph[9]};
	    	graph[9].neighbors = new Node[] {graph[5],graph[6],graph[8]};
	    	 for (int i = 1; i <= 50; i++) 
	              for (int j = 1; j <= 50; j++) 
	                  adj[i][j] = 0;
	    	  for (int c = 1; c <= 50; c++) 
                  visited[c] = 0;
	    	//set adj array
	    	adj =new int [][] {{0,0,0,0,0,0,0,0,0,0,0},        
	                           {0,0,1,1,1,0,0,0,0,0,0},        
	                           {0,1,0,0,1,1,0,0,0,0,0},       
	                           {0,1,0,0,0,0,1,0,0,0,0},        
	                           {0,1,1,0,0,1,1,1,0,0,0},       
	                           {0,0,1,0,1,0,0,0,1,0,0},      
	                           {0,0,0,1,1,0,0,1,0,0,1},       
	                           {0,0,0,0,0,0,1,0,1,0,1},       
	                           {0,0,0,0,0,1,0,1,0,1,0},        
	                           {0,0,0,0,0,0,0,0,1,0,1},
	                           {0,0,0,0,0,0,1,1,0,1,0}};     
 	               Stack path = new Stack();	         
 	               if(technique.equals("dfs"))
 	                    {path = DFS(source,10,goal);}
 	               else if(technique.equals("bfs"))
 	            	   path = BFS(source,10,goal);
 	                 return path;
 	                
 	                
	    }

Stack DFS(int initial_node, int n,int goal) 
{ 
Stack path = new Stack();
int u, i,x = 0;
s.top = -1;
s.push(initial_node);
System.out.println("\nDFS traversal for given graph is : ");
breakWhile:
while (!s.isempty()) {

u = s.pop();
if (visited[u] == 0)            
{ 
System.out.print("\n" + u);
visited[u] = 1;
path.push(u);
if(u==goal)
{	x=u;   break breakWhile;  }
}
for (i = 1; i <= n; i++)            
{ 
if ((adj[u][i] == 1) && (visited[i] == 0))                 
{ 
s.push(u);
visited[i] = 1;
System.out.print(" " + i);
u = i; 
path.push(i);
if(i==goal)
{	x=i;   break breakWhile;  }

} 

} 

}

return path;
}
Stack BFS(int initial_node,int n ,int goal){
	Stack path = new Stack();
    int u, i;
    Queue<Integer> q=new LinkedList<Integer>();
    q.add(initial_node);
    System.out.println("\nDFS traversal for given graph is : ");
    breakWhile:
    	while(!q.isEmpty())
    	{
    		u = q.remove();
            if (visited[u] == 0)            
                { 
               System.out.print("\n" + u);
               visited[u] = 1;
               path.push(u);
               if(u==goal)
                  break breakWhile;  
                }
            for (i = 1; i <= n; i++)            
            { 
if ((adj[u][i] == 1) && (visited[i] == 0))                 
                { 
q.add(i);
visited[i] = 1;
System.out.print(" " + i);
path.push(i);
if(i==goal)
  break breakWhile;  

} 
        
}
    u=q.remove();
    
}

return path;
    	} 
}
