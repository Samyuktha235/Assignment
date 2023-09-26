package DataStructures;
import java.util.*;
class Node3
{
    int data;
    Node3 prev;
    Node3 next;
    public Node3(int data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
public class DoublyLinkedList {
    public static Node3 head=null;
    public static Node3 tail=null;
    public static void addfirst(int data)
    {
        Node3 newnode=new Node3(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else {
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
        System.out.println("Element added to the list");
    }
    public static void addlast(int data)
    {
        Node3 newnode =new Node3(data);
        if(tail==null)
        {
            head=newnode;
            tail=newnode;
        }
        else {
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
        System.out.println("Element added to the list");
    }
    public static void add(int pos,int ele)
    {
        Node3 newnode=new Node3(ele);
        int i=2;
        Node3 temp=head;
        if(pos==1)
        {
           /* newnode.next=head;
            head.prev=newnode;
            head=newnode;*/
            addfirst(ele);
        }
        else {
            while(temp.next!=null) {
                if (i == pos) {
                    newnode.next = temp.next;
                    newnode.prev = temp;
                    temp.next.prev = newnode;
                    temp.next = newnode;
                }
                i++;
                temp=temp.next;
            }
        }
        if(i+1==pos)
        {
            addlast(ele);
        }
    }
    public static boolean deletefirst()
    {
        boolean flag=true;
        if(head==null)
        {
            System.out.println("List is empty");
            return !flag;
        }
        else if(head==tail)
        {
          head=null;
          tail=null;
          flag=false;
        }
        else {
            head=head.next;
            head.prev.next=null;
            head.prev=null;
            flag=false;
        }
        System.out.println("Deleted element from the list");
        return !flag;
    }
    public static boolean deletelast()
    {
        boolean flag=true;
        if(head==null)
        {
            System.out.println("List is Empty");
            return !flag;
        }
        else if(head==tail)
        {
            head=null;
            tail=null;
            flag=false;
        }
        else {
            tail=tail.prev;
            tail.next.prev=null;
            tail.next=null;
            flag=false;
        }
        System.out.println("Deleted element from the list");
        return !flag;
    }
    public static boolean delete(int pos)
    {
        boolean flag=true;
        if(head==null)
        {
            System.out.println("List is empty");
            return !flag;
        }
        if(pos==1)
        {
            /*head=head.next;
            head.prev.next=null;
            head.prev=null;*/
            deletefirst();
            flag=false;
        }
        else {
            Node3 temp=head.next;
            int i=2;
            while(temp!=null)
            {
                if(i==pos)
                {
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                    temp.next=null;
                    temp.prev=null;
                    flag=false;
                    break;
                }
                i++;
                temp=temp.next;
            }
            /*if(i==pos)
            {
                deletelast();
                flag=false;
            }*/
        }
        System.out.println("Element deleted");
        return !flag;
    }
    public static boolean deleteElement(int data)
    {
        boolean flag=true;
        if(head==null)
        {
            System.out.println("List is empty");
            return !flag;
        }
        Node3 temp=head.next;
        if(head.data==data)
        {
            deletefirst();
            flag=false;
        }
        else if(tail.data==data) {
            deletelast();
            flag=false;
        }
        else {
        while(temp.next!=null)
        {
            if(temp.data==data)
            {
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                temp.prev=null;
                temp.next=null;
                flag=false;
                break;
            }
            temp=temp.next;
        }
          if(flag)
          {
              System.out.println("Element not found to delete it");
          }
        }
        return !flag;
    }
    public static void search(int data)
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node3 temp=head;
        boolean flag=true;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                System.out.println("Element found");
                flag=false;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            System.out.println("Element not found");
        }
    }
    public static void reverse()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node3 curr=head;
            Node3 temp;
        while(curr.next!=null)
        {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            /*next=curr.next;
            curr.next=prev;
            curr.prev=next;
            next.prev=next.next;
            next.next=curr;
            prev=curr;
            curr=next;*/
        curr=curr.prev;
        }
        temp=curr.prev;
        curr.prev=curr.next;
        curr.next=temp;
        head=curr;
        System.out.println("Reverse performed");
    }
    public static void display()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node3 temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        int size=0;
        while(flag)
        {
            System.out.println("Enter the choice to perform the Operations:");
            System.out.println("1.AddFirst\n2.AddLast\n3.Add at position\n4.DeleteFirst\n5.DeleteLast\n6.Delete at Position\n7.Delete an element\n8.Search\n9.Reverse\n10.Display\n11.End Operations");
            int a=sc.nextInt();
            if(a<1 || a>11)
            {
                System.out.println("Enter a valid operation");
            }
            else {
                switch (a)
                {
                    case 1:
                    {
                        System.out.println("Enter at element to add at first:");
                        addfirst(sc.nextInt());
                        size++;
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter the element to add at last");
                        addlast(sc.nextInt());
                        size++;
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter the element to add at a position:");
                        System.out.println("Position:");
                        int position= sc.nextInt();
                        System.out.println("Element:");
                        int element= sc.nextInt();
                        if(position>size+1)
                        {
                            System.out.println("Enter a valid position.The size is "+size);
                        }
                        else {
                        add(position,element);
                        size++;
                        }
                        break;
                    }
                    case 4:
                    {
                        if(deletefirst()) {
                            size--;
                        }
                        break;
                    }
                    case 5:
                    {
                        if(deletelast())
                        {
                        size--;
                        }
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter the position to delete:");
                        System.out.println("Position:");
                        int position=sc.nextInt();
                        if(position<=size)
                        {
                            if(delete(position))
                            {
                            size--;
                            }
                        }
                        else
                        {
                            System.out.println("Enter valid position to delete");
                        }
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter the element to delete");
                        System.out.println("Element:");
                        if(deleteElement(sc.nextInt()))
                        {
                            size--;
                        }
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Enter the element to search:");
                        search(sc.nextInt());
                        break;
                    }
                    case 9:{
                      //  System.out.println("list is Reversed");
                        reverse();
                        break;
                    }
                    case 10:{
                        System.out.println("Elements in the linked list are:");
                        display();
                        break;
                    }
                    case 11:
                    {
                        System.out.println("Operations Ended");
                        flag=false;
                        break;
                    }
                }
            }

        }
    }
}
