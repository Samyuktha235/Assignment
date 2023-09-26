package DataStructures;
import java.util.*;
public class SelectionSort {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            for(int k=0;k<n;k++)
            {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
        System.out.print("Sorted Array:");
        for(int k=0;k<n;k++)
        {
            System.out.print(arr[k]+" ");
        }
    }
}
