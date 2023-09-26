
//Singly Linked List

package DataStructures;
import java.util.*;
class Node
{
    int data;
    Node next;
    public Node(int data)
    {
       this.data=data;
       this.next=null;
    }
}

public class SinglyLinkedlist {
public static Node head=null;
public static Node tail=null;
public static void Add(int data)
{
    Node newnode=new Node(data);
    if(head==null)
    {
        head=newnode;
        tail=newnode;
    }
    else {
        tail.next=newnode;
        tail=newnode;
    }
}
public static void Delete(int data) {
    if(head==null)
    {
        System.out.println("List is empty");
        return;
    }
    Node current = head.next, temp = head;
    boolean flag = true;
    if (temp.data == data) {
        temp.next = null;
        head = current;
        System.out.println("Element Deleted");
        flag = false;
    } else {
        while (current != null) {
            if (current.data == data) {
                temp.next = current.next;
                System.out.println("Element Deleted");
                flag = false;
                break;
            }
            temp = temp.next;
            current = current.next;
        }
        if (flag) {
            System.out.println("Element not found.Hence not deleted");
        }
    }
}
public static void Search(int data1)
{
    Node current1=head;
    boolean flg=true;
    if(head==null)
    {
        System.out.println("List is empty.Therefore element not found");
    }
    else {
        while(current1.next!=null)
        {
            if(current1.data==data1)
            {
                System.out.println("Element found");
                flg=false;
                break;
            }
            current1=current1.next;
        }
        if(flg)
        {
            System.out.println("Element not found");
        }
    }
}
public static void Insert(int pos,int ele)
{
    Node newnode=new Node(ele);
    int i=2;
    Node temp=head;
    if(pos==1)
    {
        newnode.next=head;
        head=newnode;
    }
    else
    {
        while(temp!=null)
        {
            if(i==pos)
            {
              newnode.next=temp.next;
              temp.next=newnode;
                System.out.println("Element Inserted");
                break;
            }
            i++;
            temp=temp.next;
        }
    }

}
public static void Reverse()
{
    if(head==null)
    {
        System.out.println("The list is empty");
        return;
    }
    Node curr=head,prev=null,next=null;
    while(curr!=null)
    {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    head=prev;
}
/*
public static void Move(int from,int to)
{
    Node temp,fprev=null,lprev=null,first=head,second=head;
    for(int i=1;i<from;i++)
    {
        fprev=first;
        first=first.next;
    }
    for(int i=1;i<to;i++)
    {
        lprev=second;
        second=second.next;
    }
    if(fprev==null)
    {
         temp=first.next;
        first.next=second.next;
        second.next=temp;
        lprev.next=first;
    }
    else {
        temp=first.next;
        first.next=second.next=temp;
        lprev.next=first;
        fprev.next=second;
    }
    System.out.println("The elements are swapped");
}
*/
public static void Display()
{
    Node curr=head;
    if(head==null)
    {
        System.out.println("List is empty");
    }
    else
    {
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}

public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    boolean flag=true;
    int size=0;
    while(flag)
    {
        System.out.println("1.Add\n2.Delete\n3.Search\n4.insert\n5.reverse\n6.Display\n7.Complete Operation");
        int a=sc.nextInt();
        if(a<1 || a>7)
        {
            System.out.println("Enter a valid operation!");
        }
        else {

        switch(a)
        {
            case 1: {
                System.out.println("Enter the num to add:");
                Add(sc.nextInt());
                size++;
                break;
            }
            case 2:{
                System.out.println("Enter the element to delete:");
                Delete(sc.nextInt());
                size--;
                break;
            }
            case 3:{
                System.out.println("Enter the element to search:");
                Search(sc.nextInt());
                break;
            }
            case 4:{
                System.out.println("Enter the position and element to insert:");
                System.out.println("Position:");
                int position=sc.nextInt();
                System.out.println("Element:");
                int element=sc.nextInt();
                if(position<=size+1)
                {
                Insert(position,element);
                size++;
                }
                else {
                    System.out.println("Enter a valid position. The size of list is "+size);
                }
                break;
            }
            case 5:{
                System.out.println("The list is reversed");
                Reverse();
                break;
            }
           /* case 6:{
                System.out.println("Enter the position to move the element");
                System.out.println("From:");
                int from=sc.nextInt();
                System.out.println("To:");
                int to=sc.nextInt();
                Move(from,to);
                break;
            }*/
            case 6: {
                System.out.println("Displaying the list:");
                Display();
                break;
            }
            case 7:{
                flag=false;
                break;
            }
        }
        }
    }
}

}
