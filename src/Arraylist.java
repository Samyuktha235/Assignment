import java.util.*;
public class Arraylist{
    public static void main(String args[])
    {
        ArrayList <Integer> al=new ArrayList <Integer> ();
        System.out.println("Adding the elements in ArrayList:");
        for(int i=11;i<=20;i++)
        {
            al.add(i); //Adding elements with the index
        }
        System.out.println(al);
        System.out.println("After adding 23 at index 5:");
        al.add(5,23); //Adding element at index 5
        System.out.println(al);
        System.out.println("whether the arraylist contains 12?");
        System.out.println(al.contains(12)); //Checking ArrayList whether it contains 12
        System.out.println("whether the arraylist contains 40?");
        System.out.println(al.contains(40)); //Checking ArrayList whether it contains 40
        System.out.println("To set the index 8 with 11:");
        al.set(8,11); //to replace the element at a particular index
        System.out.println(al);
        System.out.println("To get the last index of element 11: "+al.lastIndexOf(11));
        ArrayList <Integer> al2=new ArrayList <Integer> ();
        System.out.println("ArrayList2 After cloning from ArrayList1:");
        al2 = (ArrayList) al.clone(); //Cloning the ArrayList
        System.out.println(al2);
        System.out.println("ArrayList after removing the element at index 3:");
        al.remove(3); //Removing the element at index 3
        System.out.println(al);
        System.out.println("ArrayList after removing 17 from the list");
        al.remove(al.indexOf(17)); //Removing the element by using the index of the element
        System.out.println(al);
        System.out.println("using for loop:"); //Printing using for loop
        for(int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
        System.out.println("Using for each loop:"); //Printing using for each loop
        for(Integer i:al)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Using Iterator:"); //Printing using Iterator
        Iterator it=al.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("Using List Iterator:"); //Printing in reverse order using List Iterator
        ListIterator<Integer> listIterator=al.listIterator(al.size());
        while(listIterator.hasPrevious())
        {
            System.out.print(listIterator.previous()+" ");
        }
        System.out.println();
        System.out.println("Reversal of the ArrayList:");
        Collections.reverse(al); //Reversing the ArrayList
        System.out.println(al);
        System.out.println("To check whether the Arraylist is Empty");
        System.out.println(al.isEmpty());
        System.out.println("After replacing all elements to 5 in the arraylist:");
        al.replaceAll(e -> 5); //to replace all the  elements in the arraylist
        System.out.println(al);
        System.out.println("After clearing the ArrayList");
        al.clear(); //Clearing the ArrayList
        System.out.println(al);
        System.out.println("To check whether the Arraylist is Empty");
        System.out.println(al.isEmpty()); //to check whether the arraylist is empty
    }
}
