
//Stack using Doubly Linked List

package DataStructures;
import java.util.*;
class Node1{
    int data;
    Node1 next;
    Node1 prev;
    public Node1(int data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public class Stack {
    public static Node1 head=null;
    public static Node1 tail=null;
    public static void Push(int data)
    {
        Node1 newnode=new Node1(data);
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
        System.out.println(data+" is added to the stack");
    }
    public static void pop()
    {
        System.out.println(tail.data+ " is popped from the stack");
        if(tail==head)
        {
            head=null;
            tail=null;
        }
        else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
    }
    public static void peek()
    {
        System.out.println("The top element of stack is "+tail.data);
    }
    public static void isEmpty()
    {
        if(head==null)
        {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
    public static void Search(int data)
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node1 temp=head;
        boolean flg=true;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                System.out.println("Element found");
                flg=false;
                break;
            }
            temp=temp.next;
        }
        if(flg)
        {
            System.out.println("Element not Found");
        }
    }
    public static void display()
    {
        Node1 temp = head;
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
            System.out.println("Enter the Choice to proceed the operation in the Stack:");
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty\n5.Size of the Stack\n6.Display\n7.End operation");
            int choice=sc.nextInt();
            if (choice < 1 || choice > 7) {
                System.out.println("Enter a valid operation");
            }
            else {
                switch (choice) {
                    case 1: {
                        System.out.println("Enter the value to add to the stack:");
                        Push(sc.nextInt());
                        size++;
                        break;
                    }
                    case 2: {
                        if (head == null) {
                            System.out.println("Stack is empty. Cannot pop the elements");
                            break;
                        } else {
                            pop();
                            size--;
                            break;
                        }
                    }
                    case 3: {
                        if (head == null) {
                            System.out.println("Stack is empty.Cannot peek from the stack");
                            break;
                        }
                        peek();
                        break;
                    }
                    case 4: {
                        isEmpty();
                        break;
                    }
                    case 5: {
                        System.out.println("Size of the stack is " + size);
                        break;
                    }
                /*case 6:{
                    System.out.println("Enter the element to search:");
                    Search(sc.nextInt());
                    break;
                }*/
                    case 6: {
                        if(size==0)
                        {
                            System.out.println("Stack is empty");
                        }
                        else{
                            System.out.println("The stack is:");
                            display();
                        }
                        break;
                    }
                    case 7: {
                        System.out.println("Operations Completed");
                        flag = false;
                        break;
                    }
                }
            }
        }
    }
}
