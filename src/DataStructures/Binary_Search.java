package DataStructures;
import java.util.*;
public class Binary_Search {
    public static void BinarySearch(int arr[],int k,int start,int end)
    {
        int count=0;
        boolean flag=true;
        int mid=(start+end)/2;
        while(start<=end)
        {
            if(arr[mid]==k)
            {
                count++;
                flag=false;
                break;
            }
            else if(k<arr[mid]){
                end=mid-1;
                count++;
            }
            else if(k>arr[mid])
            {
                start=mid+1;
                count++;
            }
            mid=(start+end)/2;
            if(start>end)
            {
                break;
            }
        }
        if(flag)
        {
            System.out.println("Element not Found after "+count+" of comparisons");
        }
        else
        {
            System.out.println("Element found with "+count+" of comparisons");
        }
    }
        public static void main(String args[])
        {
           Scanner sc=new Scanner(System.in);
            System.out.println("Enter the size of an array:");
           int n=sc.nextInt();
           int arr[]=new int[n];
            System.out.println("Enter the elements:");
           for(int i=0;i<n;i++)
           {
               arr[i]=sc.nextInt();
           }
            System.out.println("Enter the element to find:");
           int k=sc.nextInt();
           BinarySearch(arr,k,0,n-1);
        }
}
