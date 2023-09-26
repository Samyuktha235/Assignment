package DataStructures;
import java.util.*;
class nNode
        {
            int data;
            ArrayList<nNode> children;
            public nNode(int data)
            {
                this.data=data;
                this.children= new ArrayList<nNode> ();
            }
        }
public class N_ary_Tree {
    public static nNode root=null;
    public static int n;
    public static void insert(int data)
    {
        nNode newnode=new nNode(data);
        Queue<nNode> q= new LinkedList<>();
        if(root==null)
        {
            root=newnode;
            return;
        }
        else {
            q.add(root);
            while (!q.isEmpty()) {
                nNode temp = q.poll();
                if (temp.children.size() < n) {
                    temp.children.add(newnode);
                    return;
                } else {
                    q.addAll(temp.children);
                }
            }

        }
    }
    public static void InsertAfter(int data,int insafter)
    {
        nNode newnode=new nNode(data);
        Queue<nNode> q=new LinkedList<>();
        boolean flag=false;
        if(root==null)
        {
            System.out.println("Tree is Empty");
            return;
        }
        else {
            q.add(root);
            while(!q.isEmpty())
            {
                nNode temp=q.poll();
                if(temp.data==insafter)
                {
                    if(temp.children.size()<n)
                    {
                        temp.children.add(newnode);
                        flag=true;
                        return;
                    }
                    else {
                        System.out.println("The space is not there to insert");
                    }
                }
                else
                {
                    q.addAll(temp.children);
                }
            }
        }
        if(!flag)
        {
            System.out.println("Enter the correct position to insert");
        }
    }
    public static void Delete(int data)
    {
        boolean flag=false;
        if(root==null)
        {
            System.out.println("Tree is empty");
        }
        if(root.data==data)
        {
            if(root.children.size()==0)
            {
                root=null;
               flag=true;
            }
            else {
                nNode temp=root.children.get(0);
                root.children.remove(temp);
                if(!root.children.isEmpty())
                {
                    temp.children.addAll(root.children);
                }
                root=temp;
                flag= true;

            }
        }
        else {
            Queue <nNode> q=new LinkedList<>();
            q.add(root);
            boolean contains=false;
            int pos=-1;
            while(!q.isEmpty())
            {
                boolean flg=false;
                nNode temp1=q.poll();
                for(int i=0;i<temp1.children.size();i++)
                {
                    if(data==temp1.children.get(i).data)
                    {
                        pos=i;
                        contains=true;
                        flg=true;
                        break;
                    }
                }
                if(contains && temp1.children.get(pos).children.isEmpty())
                 {
                    temp1.children.remove(pos);
                    flg=true;
                    flag=true;
                    break;
                 }

                if(contains)
                {
                    nNode temp2=temp1.children.get(pos);
                    temp1.children.add(temp2.children.get(0));
                    temp2.children.remove(0);
                    temp1.children.get(temp1.children.size()-1).children.addAll(temp2.children);
                    temp1.children.remove(pos);
                    flag=true;
                    break;
                }
                if(!flg)
                {
                    q.addAll(temp1.children);
                }
            }
        }
            if(flag)
            {
                System.out.println("The element is deleted");
            }
            else
            {
                System.out.println("Element is not found");
            }
    }
    public static void heightOfTree()
    {
        Queue<nNode> q=new LinkedList<>();
        int height=0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            nNode temp=q.poll();
            if(temp==null)
            {
                height++;
                if(!q.isEmpty())
                {
                q.add(null);
                }
            }
            else
            {
                q.addAll(temp.children);
            }
        }
        System.out.println("The height of the tree is "+height);
    }

    public static void BFSdisplay(nNode root)
    {
        Queue<nNode> q=new LinkedList<>();
        if(root==null)
        {
            System.out.println("Tree is empty");
        }
        q.add(root);
        while(!q.isEmpty())
        {
            nNode temp=q.poll();
            System.out.print(temp.data+" ");
            q.addAll(temp.children);
        }
        System.out.println();
    }
    public static void DFS_display()
    {
        Stack <nNode> s= new Stack<nNode>();
        if(root==null)
        {
            System.out.println("Tree is empty");
            return;
        }
        s.push(root);
        while(!s.isEmpty())
        {
            nNode temp=s.pop();
            LinkedList<nNode> l=new LinkedList<>();
            System.out.print(temp.data+" ");
            l.addAll(temp.children);
            Collections.reverse(l);
            s.addAll(l);
            l.clear();
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes:\nn:");
        n=sc.nextInt();
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter the operation to proceed:");
            System.out.println("1.InsertAfter\n2.Insert\n3.Height of the tree\n4.Delete an element\n5.BFS display\n6.DFS display\n7.End operation");
            int a=sc.nextInt();
            switch (a)
            {
                case 1:
                {
                    System.out.println("Enter the element to insert:");
                    int ele=sc.nextInt();
                    System.out.println("Enter the value of the node to insert after:");
                    int pos=sc.nextInt();
                    InsertAfter(ele,pos);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the value to insert:");
                    int val=sc.nextInt();
                    insert(val);
                    break;
                }
                case 3:
                {
                    heightOfTree();
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the element to delete:");
                    int dval=sc.nextInt();
                    Delete(dval);
                    break;
                }
                case 5:
                {
                    System.out.println("BFS display:");
                    BFSdisplay(root);
                    break;
                }
                case 6:
                {
                    System.out.println("DFS display:");
                    DFS_display();
                    break;
                }
                case 7:
                {
                    flag=false;
                    break;
                }
            }

        }
    }
}
