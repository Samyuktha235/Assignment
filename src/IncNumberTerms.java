import java.math.BigInteger;
import java.util.*;
public class IncNumberTerms {

   public static BigInteger a1=BigInteger.valueOf(-1);
    public static BigInteger b1=BigInteger.valueOf(1);

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        boolean flag=true;
        System.out.println("Enter the term:");
        while(flag) {
        String count=sc.nextLine();
            if (isNumeric(count)) {
              int n=Integer.parseInt(count);
              a=a+n;
              for(int i=b;i<a;i++)
              {
                 BigInteger c=BigInteger.valueOf(0);
                 c=a1.add(b1);
                  a1=b1;
                  b1=c;
                  System.out.print(c+" ");
              }
               // fib(a1,b1,a,b);
              b=a;
            } else {
                System.out.println("Loop exited");
                flag=false;
            }
        }
    }
   /*public static void fib(BigInteger a1,BigInteger b1,int a,int b)
    {
        while(b<a)
        {
            BigInteger c=BigInteger.valueOf(0);
            c=a1.add(b1);
            a1=b1;
            b1=c;
            System.out.print(c+" ");
            fib(a1,b1,a,b+1);
        }
    }*/
    public static boolean isNumeric(String count)
    {
        try
        {
            int n=Integer.parseInt(count);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
