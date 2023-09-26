

import java.math.BigInteger;
import java.util.*;
public class Fibanocci_series {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=0,b=1;
        System.out.println("Enter the n:");
        int n=sc.nextInt();
        /*System.out.println("Fibanocci series using for loop:");
        System.out.print(a+" "+b);
        for(int i=2;i<n;i++)
        {
            int c=a+b;
            a=b;
            b=c;
            System.out.print(" "+c);
        }

        System.out.println();
        System.out.println("Fibanocci series using recursion:");
        for(int i=0;i<n;i++)
        {
            System.out.print(fibrec(i)+" ");
        }*/
        System.out.println("Fibanocci series using for loop:");
        fibbg(n);
        System.out.println();
        System.out.println("Fibanocci Series using recurrsion:");
        fibbgrec(0,n);
        System.out.println();
        System.out.println("Reversed Fibanocci Series using recurrsion:");
        fibbgrecrev(n);
    }
    public static int fibrec(int count)
    {
        if(count==0)
        {
            return 0;
        }
        if(count==1 || count==2)
        {
            return 1;
        }

        return fibrec(count-1)+fibrec(count-2);
    }

    public static void fibbg(int n) //fibanocci series using for loop
    {
        BigInteger a=BigInteger.valueOf(-1);
        BigInteger b=BigInteger.valueOf(1);
        for(int i=0;i<=n;i++)
        {
            BigInteger c=BigInteger.valueOf(0);
            c=a.add(b);
            a=b;
            b=c;
            System.out.print(c+" ");
        }
    }
    public static BigInteger a1=BigInteger.valueOf(-1);
    public static BigInteger b1=BigInteger.valueOf(1);
    public static BigInteger a2=BigInteger.valueOf(-1);
    public static BigInteger b2=BigInteger.valueOf(1);
    public static void fibbgrec(int i,int n) //fibanocci series using recurrsion
    {
        if(i>n)
        {
            return;
        }
        BigInteger c=BigInteger.valueOf(0);
        c=a1.add(b1);
        System.out.print(c+" ");
        a1=b1;
        b1=c;
         fibbgrec(i+1,n);
    }

    public static void fibbgrecrev(int n) //Fibanocci series in reversed order using recurrsion
    {
        if(n<0)
        {
            return;
        }
        BigInteger c=BigInteger.valueOf(0);
        c=a2.add(b2);
        a2=b2;
        b2=c;
        fibbgrecrev(n-1);
        System.out.print(c+" ");
    }
}
