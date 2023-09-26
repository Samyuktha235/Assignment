package DataStructures;
import java.util.*;
class GNode
{
    int data;
    ArrayList <GNode> neighbours;
    public GNode(int data)
    {
        this.data=data;
        this.neighbours=new ArrayList<>();
    }
}
public class Graph_Directed {
    static ArrayList <GNode> nodes=new ArrayList<>();

    public static void addNode(int data)
    {
        GNode newnode=new GNode(data);
        nodes.add(newnode);
    }
    public static void addEdge(int sourceNode,int destNode)
    {
        GNode source=getNode(sourceNode);
        GNode dest=getNode(destNode);
        if(source!=null && dest!=null)
        {
            source.neighbours.add(dest);
            System.out.println("Node Added");
        }
        else
        {
            System.out.println("Node not present to add");
        }
    }
    public static GNode getNode(int val)
    {
        for(GNode i:nodes)
        {
            if(i.data==val)
            {
                return i;
            }
        }
        return null;
    }
    public static void display()
    {
        if(nodes.isEmpty())
        {
            System.out.println("Graph is empty");
            return;
        }
        for(GNode pnode:nodes)
        {
            System.out.print(pnode.data+"-->");
            for(GNode pnnodes: pnode.neighbours)
            {
                System.out.print(pnnodes.data+" ");
            }
            System.out.println();
        }
    }
    public static void BFSdisplay()
    {
        if(nodes.isEmpty())
        {
            System.out.println("Graph is empty");
            return;
        }
        System.out.println("BFS display:");
        System.out.println("Origin node:"+nodes.get(0).data);
        Queue<GNode> q=new LinkedList<>();
        Queue <Integer> visited=new LinkedList<>();
        q.add(nodes.get(0));
            visited.add(nodes.get(0).data);
        while(!q.isEmpty())
        {
            GNode temp=q.poll();
            System.out.print(temp.data+" ");
            for(GNode i:temp.neighbours)
            {
                if(!visited.contains(i.data))
                {
                    q.add(i);
                    visited.add(i.data);
                }
            }
        }
    }
    public static void DFS_display()
    {
        if(nodes.isEmpty())
        {
            System.out.println("Graph is empty");
            return;
        }
        System.out.println("DFS Display:");
        System.out.println("Origin node:"+nodes.get(0).data);
        Stack <GNode> s= new Stack<>();
        Stack <Integer> vis=new Stack<>();
        s.push(nodes.get(0));
        vis.push(nodes.get(0).data);
        while(!s.isEmpty())
        {
            GNode temp=s.pop();
            System.out.print(temp.data+" ");
            for(GNode j:temp.neighbours)
            {
               if(!vis.contains(j.data))
               {
                   s.add(j);
                   vis.add(j.data);
               }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
      /*  addNode(23);
        addNode(5);
        addNode(32);
        addNode(3);
        addNode(2);
        addNode(55);
        addEdge(23,5);
        addEdge(5,32);
        addEdge(32,3);
        addEdge(3,55);
        addEdge(3,2);
        addEdge(2,55);
        addEdge(2,23);
        addEdge(55,23);
        display();
        BFSdisplay();
        System.out.println();
        DFS_display();*/
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter the option to continue:\n1.AddNode\n2.AddEdges\n3.Display\n4.BFS Display\n5.DFS Display\n6.End Operation");
            int a=sc.nextInt();
            switch(a) {
                case 1: {
                    System.out.println("Enter the value to add as Node:");
                    int n = sc.nextInt();
                    addNode(n);
                    break;
                }
                case 2: {
                    System.out.println("Enter the edges to connect:");
                    System.out.println("Enter the source Node:");
                    int so = sc.nextInt();
                    System.out.println("Enter the Destiation node:");
                    int des = sc.nextInt();
                    addEdge(so, des);
                    break;
                }
                case 3: {
                    display();
                    break;
                }
                case 4:
                {
                    BFSdisplay();
                    System.out.println();
                    break;
                }
                case 5:
                {
                    DFS_display();
                    System.out.println();
                    break;
                }
                case 6:
                {
                    flag=false;
                    break;
                }
            }
        }
    }
}
