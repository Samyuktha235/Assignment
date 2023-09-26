import java.util.*;
public class butterfly_pattern {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        bfpatup(0,n);
        bfpatdown(0,n);
       /* for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++) {
                System.out.print("*");
            }
            for(int j=n-1;j>i;j--)
            {
                System.out.print(" ");
            }
            for(int j=n-1;j>i;j--)
            {
                System.out.print(" ");
            }

            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0;i<=n-1;i++)
        {
            for(int j=n-1;j>=i;j--)
            {
                System.out.print("-");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            for(int j=n-1;j>=i;j--)
            {
                System.out.print("-");
            }
            System.out.println();
        }*/

    }

    public static void bfpatup(int i,int n)
    {
        if(i>=n)
        {
            return;
        }
        for(int j=0;j<=i;j++) {
            System.out.print("*");
        }
        for(int j=n-1;j>i;j--)
        {
            System.out.print(" ");
        }
        for(int j=n-1;j>i;j--)
        {
            System.out.print(" ");
        }

        for(int j=0;j<=i;j++)
        {
            System.out.print("*");
        }
        System.out.println();
        bfpatup(i+1,n);
    }

    public static void bfpatdown(int i,int n)
    {
        if(i>n-1)
        {
            return;
        }
        for(int j=n-1;j>=i;j--)
        {
            System.out.print("-");
        }
        for(int j=1;j<=i;j++)
        {
            System.out.print(" ");
        }
        for(int j=1;j<=i;j++)
        {
            System.out.print(" ");
        }
        for(int j=n-1;j>=i;j--)
        {
            System.out.print("-");
        }
        System.out.println();
        bfpatdown(i+1,n);
    }
}
