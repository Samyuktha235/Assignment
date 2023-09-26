package DataStructures;
import java.util.*;

class Node4
{
    int data;
    Node4 prev;
    Node4 next;
    public Node4(int data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}

public class CircularlyLinkedlist {

    public static Node4 head=null;
    public static Node4 tail=null;
    public static void addfirst(int data)
    {
        Node4 newnode=new Node4(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
            head.prev=tail;
            tail.next=head;
        }
        else {
            newnode.next=head;
            newnode.prev=tail;
            tail.next=newnode;
            head.prev=newnode;
            head=newnode;
        }
        System.out.println("Element added to the list");
    }
    public static void addlast(int data)
    {
        Node4 newnode =new Node4(data);
        if(tail==null)
        {
            head=newnode;
            tail=newnode;
            head.prev=tail;
            tail.next=head;
        }
        else {
            newnode.next=head;
            head.prev=newnode;
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
        System.out.println("Element added to the list");
    }
    public static void add(int pos,int ele)
    {
        Node4 newnode=new Node4(ele);
        int i=2;
        Node4 temp=head;
        if(pos==1)
        {
            /*newnode.next=head;
            head.prev=newnode;
            head=newnode;*/
            addfirst(ele);
        }
        else {
            while(temp.next!=head) {
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
        if(i==pos)
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
            tail.next=head;
            head.prev.next=null;
            head.prev.prev=null;
            head.prev=tail;
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
            tail.next.next=null;
            tail.next=head;
            head.prev=tail;
            flag=false;
        }
        System.out.println("Deleted element from the list");
        return !flag;
    }
    public static boolean delete(int pos)
    {
        boolean flag=true;
        if(pos==1)
        {
            /*head=head.next;
            head.prev.next=null;
            head.prev=null;*/
            if(deletefirst())
            {
                flag=false;
            }
        }
        else {
            Node4 temp=head.next;
            int i=2;
            while(temp!=head)
            {
                //if(temp==tail)
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
                if(deletelast()){
                    flag=false;
                }
            }*/
        }
        System.out.println("Element deleted");
        return !flag;
    }

    public static boolean deleteElement(int data)
    {
        Node4 temp=head.next;
        boolean flag=true;
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
            while(temp.next!=head)
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
        Node4 temp=head.next;
        boolean flag=true;
        if(head.data==data)
        {
            System.out.println("Element found");
            flag=false;
        }
        else {
            while (temp != head) {
                if (temp.data == data) {
                    System.out.println("Element found");
                    flag = false;
                    break;
                }
                temp = temp.next;
            }
        }
        if(flag)
        {
            System.out.println("Element not found");
        }
    }
    public static void reverse()
    {
        Node4 curr=head;
        tail=head;
        Node4 temp;
        while(curr.next!=head)
        {
            temp=curr.next;
            curr.next=curr.prev;
             curr.prev=temp;
             curr=curr.prev;
        }
        temp=curr.next;
        curr.next=curr.prev;
        curr.prev=temp;
        head=curr;
        System.out.println("Reverse performed");
    }
    public static void display()
    {
        Node4 temp=head.next;
        System.out.print(head.data+" ");
        while(temp!=head)
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
        while(flag) {
            System.out.println("Enter the Choice to proceed the operation in the list:");
            System.out.println("1.AddFirst\n2.AddLast\n3.Add at position\n4.DeleteFirst\n5.DeleteLast\n6.Delete at Position\n7.Delete an element\n8.Search\n9.Reverse\n10.Display\n11.End Operations");
            int a = sc.nextInt();
            if (a < 1 || a > 11) {
                System.out.println("Enter a valid operation");
            } else {
                switch (a) {
                    case 1: {
                        System.out.println("Enter at element to add at first:");
                        addfirst(sc.nextInt());
                        size++;
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the element to add at last");
                        addlast(sc.nextInt());
                        size++;
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the element to add at a position:");
                        System.out.println("Position:");
                        int position = sc.nextInt();
                        System.out.println("Element:");
                        int element = sc.nextInt();
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
                    case 4: {
                        if(deletefirst())
                        {
                             size--;
                        }
                        break;
                    }
                    case 5: {
                       if(deletelast())
                       {
                        size--;
                       }
                        break;
                    }
                    case 6: {
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
                    case 7: {
                        System.out.println("Enter the element to delete");
                        System.out.println("Element:");
                        if(deleteElement(sc.nextInt()))
                        {
                            size--;
                        }
                        break;
                    }
                    case 8: {
                        System.out.println("Enter the element to search:");
                        search(sc.nextInt());
                        break;
                    }
                    case 9: {
                        System.out.println("list is Reversed");
                        reverse();
                        break;
                    }
                    case 10: {
                        System.out.println("Elements in the linked list are:");
                        display();
                        break;
                    }
                    case 11: {
                        System.out.println("Operations Ended");
                        flag = false;
                        break;
                    }
                }
            }
        }
    }
}
