package DataStructures;
import java.util.*;
class Node5{
    int data;
    Node5 next;

    public Node5(int data) {
        this.data = data;
        this.next = null;
    }
}
public class ReOrderList {
    public static Node5 head=null;
    public static Node5 tail=null;

    public static void Add(int data)
    {
        Node5 newnode=new Node5(data);
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
    public static void ReOrder(Node5 head) {
        Node5 temp=head;
        Node5 prev=null;
        Node5 tail=head;

        while(temp!=prev)
        {
            tail=temp;
            while(tail.next!=null)
            {
                prev=tail;
                tail=tail.next;
            }
            if(temp!=prev)
            {
                prev.next=null;
                tail.next=temp.next;
                temp.next=tail;
                temp=temp.next.next;
            }
        }
    }
    public static void Display() {
        Node5 curr = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
        public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter the option to execute:");
            System.out.println("1.Add\n2.ReOrder display\n3.Display\n4.End Operation");
            int a=sc.nextInt();
            switch(a) {
                case 1: {
                    System.out.println("Enter the num to add:");
                    Add(sc.nextInt());
                    break;
                }
                case 2:
                {
                    System.out.println("ReOrdered list:");
                    ReOrder(head);
                    break;
                }
                case 3:
                {
                    System.out.println("The list is:");
                    Display();
                    break;
                }
                case 4:
                {
                    flag=false;
                    System.out.println("Operations Ended");
                    break;
                }
            }
        }

    }
}
