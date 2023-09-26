package DataStructures;
import java.util.*;

public class BubbleSort {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
           boolean swap=false;
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }
            for(int k=0;k<n;k++)
            {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
            if(!swap)
            {
                break;
            }
        }
        System.out.println("Finally sorted array:");
        for(int k=0;k<n;k++)
        {
            System.out.print(arr[k]+" ");
        }
    }
}
