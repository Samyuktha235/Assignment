package DataStructures;

import java.util.*;

class GNode1
{
    int data;
    ArrayList<GNode1> gneighbour;
    public GNode1(int data)
    {
        this.data=data;
        this.gneighbour=new ArrayList<>();
    }
}
public class Graph_UnDirected {
    public static ArrayList<GNode1> al=new ArrayList<>();
    public static void addNode1(int data)
    {
        GNode1 newnode=new GNode1(data);
        al.add(newnode);
    }
    public static void addEdge1(int source,int destination)
    {
        GNode1 source1=getNode1(source);
        GNode1 des1=getNode1(destination);
        if(source1!=null && des1!=null)
        {
            source1.gneighbour.add(des1);
            des1.gneighbour.add(source1);
        }
        else{
            System.out.println("Node not Found");
        }
    }
    public static void display1()
    {
        if(al.isEmpty())
        {
            System.out.println("Graph is empty");
            return;
        }
        for(GNode1 i:al)
        {
            System.out.print(i.data+"-->");
            if(i.gneighbour.size()>0)
            {
                for(GNode1 j:i.gneighbour)
                {
                    System.out.print(j.data+" ");
                }
            }
            System.out.println();
        }
    }
    public static void BFSdisplay1()
    {
        if(al.isEmpty())
        {
            System.out.println("Graph is Empty");
            return;
        }
        Queue<GNode1> queue=new LinkedList<>();
        Queue<Integer> v=new LinkedList<>();
        queue.add(al.get(0));
        v.add(al.get(0).data);
        System.out.println("BFS Display:");
        while(!queue.isEmpty())
        {
            GNode1 temp=queue.poll();
            System.out.print(temp.data+" ");
            if(temp.gneighbour.size()>0)
            {
                for(GNode1 temp1:temp.gneighbour)
                {
                    if(!v.contains(temp1.data))
                    {
                    queue.add(temp1);
                    v.add(temp1.data);
                    }
                }
            }
        }
        System.out.println();
    }
    public static void DFS_display1()
    {
        if(al.isEmpty())
        {
            System.out.println("Graph is empty");
            return;
        }
        Stack<GNode1> s1=new Stack<>();
        Stack<Integer> v1=new Stack<>();
        s1.push(al.get(0));
        v1.push(al.get(0).data);
        while(!s1.isEmpty())
        {
            GNode1 temp=s1.pop();
            System.out.print(temp.data+" ");
            if(temp.gneighbour.size()>=0)
            {
                for(GNode1 temp1: temp.gneighbour)
                {
                    if(!v1.contains(temp1.data))
                    {
                          s1.push(temp1);
                          v1.push(temp1.data);
                    }
                }
            }
        }
        System.out.println();
    }
    public static GNode1 getNode1(int data)
    {
        for(GNode1 k:al)
        {
            if(data==k.data)
            {
                return k;
            }
        }
        return null;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter the option to continue:\n1.AddNode\n2.AddEdges\n3.Display\n4.BFS Display\n5.DFS Display\n6.End Operation");
            int a=sc.nextInt();
            switch(a) {
                case 1: {
                    System.out.println("Enter the value to add as Node:");
                    int n = sc.nextInt();
                    addNode1(n);
                    break;
                }
                case 2: {
                    System.out.println("Enter the edges to connect:");
                    System.out.println("Enter the source Node:");
                    int so = sc.nextInt();
                    System.out.println("Enter the Destiation node:");
                    int des = sc.nextInt();
                    addEdge1(so, des);
                    break;
                }
                case 3: {
                    display1();
                    break;
                }
                case 4:
                {
                    BFSdisplay1();
                    System.out.println();
                    break;
                }
                case 5:
                {
                    DFS_display1();
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
