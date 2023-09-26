package DataStructures;
import java.util.*;
public class Merge_Sort {
    public static int[] MergeSort(int arr[])
    {
        if(arr.length==1)
        {
            return arr;
        }
        int mid=arr.length/2;
        int left[]=MergeSort(Arrays.copyOfRange(arr,0,mid));
        System.out.println(Arrays.toString(left));
        int right[]=MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        System.out.println(Arrays.toString(right));

        return merge(left,right);
    }
    public static int[] merge(int left[],int right[])
    {
        int i=0,j=0,k=0;
        int mix[]= new int[left.length+ right.length];
        while(i<left.length && j< right.length)
        {
            if(left[i]<right[j])
            {
                mix[k]=left[i];
                i++;
            }
            else
            {
                mix[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length)
        {
            mix[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length)
        {
            mix[k]=right[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(mix));
        return mix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans[]=new int[n];
        ans=MergeSort(arr);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}
