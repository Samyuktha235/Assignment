package DataStructures;
import java.util.*;
public class QuickSort {
    public static void Quicksort(int arr[],int left,int right)
    {
        int pivot=arr[right];
        int j=left;
        int k=right-1;
        while(j<k)
        {
            while(arr[j]<pivot && j<k)
            {
                j++;
            }
            while(arr[k]>pivot && j<k)
            {
                if(j>k)
                {
                    break;
                }
                k--;
            }
            if(j<=k)
            {
                int temp=arr[k];
                arr[k]=arr[j];
                arr[j]=temp;
            }
            System.out.println("After loop swap:");
            for(int i=left;i<=right;i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        if(arr[j]>arr[right]) {
            int temp = arr[j];
            arr[j] = arr[right];
            arr[right] = temp;
        }
        System.out.println("After pivot swap:");
        for(int i=left;i<=right;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        if(j>left)
        {
            Quicksort(arr,left,j-1);
        }
        if(j<right)
        {
            Quicksort(arr,j+1,right);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Quicksort(arr,0,n-1);
        System.out.println("Sorted Array:");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
