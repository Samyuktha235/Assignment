package DataStructures;
import java.util.*;
class bNode
        {
            int data;
            bNode left;
            bNode right;
            public bNode(int data)
            {
                this.data=data;
                this.left=null;
                this.right=null;
            }
        }
public class BinarySearchTree {
    public static bNode root=null;
    public static void insert(bNode temp,int data){
        bNode newnode=new bNode(data);
        if(root==null)
        {
            root=newnode;
        }else {
            if(newnode.data<temp.data)
            {
                if(temp.left==null)
                {
                    temp.left=newnode;
                }
                else
                {
                    insert(temp.left, newnode.data);
                }
            }
            else {
                if(temp.right==null)
                {
                    temp.right=newnode;
                }
                else {
                    insert(temp.right,newnode.data);
                }
            }
        }
    }
    public static void giveBFS(bNode root)
    {
        Queue<bNode> queue = new LinkedList<>() ;
          queue.add(root);
          while(!queue.isEmpty())
          {
              bNode temp=queue.poll();
              System.out.print(temp.data+" ");
              if(temp.left!=null)
              {
              queue.add(temp.left);
              }
              if(temp.right!=null)
              {
              queue.add(temp.right);
              }
          }
        System.out.println();
    }
    public static bNode delete(int data,bNode temp)
    {
        if(temp==null)
        {
            return temp;
        }
        else
        {
            if(data<temp.data)
            {
                temp.left=delete(data,temp.left);
            }
            else if(data>temp.data)
            {
                temp.right=delete(data,temp.right);
            }
            else if(temp.data==data)
            {
                if(temp.left==null && temp.right==null)
                {
                   return null;
                }
                else if(temp.left==null)
                {
                    return temp.right;
                }
                else if(temp.right==null)
                {
                    return temp.left;
                }
                else {
                    bNode curr=temp.right;
                    while(curr.left!=null)
                    {
                        curr=curr.left;
                    }
                    temp.data=curr.data;
                    delete(curr.data,curr);
                }
            }
        }
        return null;
    }

    public static void search(int data,bNode temp)
    {
        //boolean flag=true;
        if(temp==null)
        {
            System.out.println("Element not found");
            return;
        }
        if(data<temp.data)
        {
            search(data,temp.left);
        }
        else if(data>temp.data)
        {
            search(data,temp.right);
        }
        else if(data==temp.data)
        {
            System.out.println("Element Found");
        }
    }
    public static void inorder(bNode temp)
    {
        if(temp==null)
        {
            return;
        }
        inorder(temp.left);
        System.out.print(temp.data+" ");
        inorder(temp.right);
    }
    public static void preorder(bNode temp)
    {
        if(temp==null)
        {
            return;
        }
        System.out.print(temp.data+" ");
        preorder(temp.left);
        preorder(temp.right);
    }
    public static void postorder(bNode temp)
    {
        if(temp==null)
        {
            return;
        }
        preorder(temp.left);
        preorder(temp.right);
        System.out.print(temp.data+" ");
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter the operation to execute:");
            System.out.println("1.Insert\n2.Delete\n3.Search\n4.BFS display\n5.Inorder\n6.PreOrder\n7.PostOrder\n8.End Operation");
            int a=sc.nextInt();
            switch (a)
            {
                case 1:
                {
                    System.out.println("Enter the value to insert:");
                    int val=sc.nextInt();
                    insert(root,val);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the value to delete:");
                    int val=sc.nextInt();
                    delete(val,root);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the value to search:");
                    int val=sc.nextInt();
                    search(val,root);
                    break;
                }
                case 4:
                {
                    System.out.println("BFS display:");
                    giveBFS(root);
                    System.out.println();
                    break;
                }
                case 5:
                {
                    System.out.println("Inorder:");
                    inorder(root);
                    System.out.println();
                    break;
                }
                case 6:
                {
                    System.out.println("Preorder:");
                    preorder(root);
                    System.out.println();
                    break;
                }
                case 7:
                {
                    System.out.println("postorder:");
                    postorder(root);
                    System.out.println();
                    break;
                }
                case 8:
                {
                    flag=false;
                    System.out.println("Operation ended");
                    break;
                }
            }
        }
    }
}
