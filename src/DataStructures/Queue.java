package DataStructures;
import java.util.*;
class Node2
{
    int data;
    Node2 prev;
    Node2 next;
    public Node2(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
public class Queue {
    public static Node2 head=null;
    public static Node2 tail=null;
    public static void add(int data)
    {
        Node2 newnode=new Node2(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else {
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }
    public static void poll()
    {
        if(head==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(head.data+" is polled from the queue");
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else
        {
            Node2 temp=head.next;
            head.next=null;
            temp.prev=null;
            head=temp;
        }
    }
    public static void peek()
    {
        if(head==null)
        {
            System.out.println("No elements in the queue.So cannot peek from the queue");
            return;
        }
        System.out.println(head.data+" is the peek of the queue");
    }
    public static void search(int data)
    {
        if(head==null)
        {
            System.out.println("Queue is Empty");
            return;
        }
        Node2 temp=head;
        boolean flg=true;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                System.out.println("Element found in the queue");
                flg=false;
                break;
            }
            temp=temp.next;
        }
        if(flg)
        {
            System.out.println("Element not found in the queue");
        }
    }
    public static void display()
    {
        if (head == null){
            System.out.println("Queue is Empty");
            return;
        }
        Node2 temp=head;
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
            System.out.println("Enter the Choice to proceed the operation in the Queue:");
            System.out.println("1.Push\n2.Poll\n3.Peek\n4.Display\n5.End operations");
            int a=sc.nextInt();
            switch(a)
            {
                case 1:
                {
                    System.out.println("Enter the element to add to the queue:");
                    add(sc.nextInt());
                    size++;
                    break;
                }
                case 2:
                {
                    if(size==0)
                    {
                        System.out.println("No elements in the queue.Hence cannot poll the element");
                        break;
                    }
                    else {
                        poll();
                        size--;
                        break;
                    }

                }
                case 3:
                {
                    peek();
                    break;
                }
               /* case 4:
                {
                    System.out.println("Enter the element to search:");
                    search(sc.nextInt());
                    break;
                }*/
                case 4:
                {
                    System.out.println("The elements in the Queue are:");
                    display();
                    break;
                }
                case 5:
                {
                    System.out.println("Operation Ended");
                    flag=false;
                    break;
                }
            }
        }
    }
}
