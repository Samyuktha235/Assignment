package DataStructures;
import java.util.*;
public class MergeSortInPlace {
    public static void MergeSortInplace(int arr[],int s,int e)
    {
        if(e-s==1)
        {
            return;
        }
        int mid=(s+e)/2;
        MergeSortInplace(arr,s,mid);
       /*for(int i=0;i<mid;i++)
       {
           System.out.print(arr[i]+" ");
       }
        System.out.println();*/
        MergeSortInplace(arr,mid,e);
        /*for(int i=mid;i<e;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();*/
        MergeInplace(arr,s,mid,e);
    }
    public static void MergeInplace(int arr[],int s,int mid,int e)
    {
        int mix[]=new int[e-s];
        int i=s;
        int j=mid;
        int k=0;

        while(i<mid && j<e)
        {
            if(arr[i]<arr[j])
            {
                mix[k]=arr[i];
                i++;
            }
            else {
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<mid)
        {
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<e)
        {
            mix[k]=arr[j];
            j++;
            k++;
        }

        for(int l=0;l< mix.length;l++)
        {
            arr[l+s]=mix[l];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        MergeSortInplace(arr,0,arr.length);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
