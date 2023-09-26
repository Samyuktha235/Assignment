package DataStructures;
import java.util.*;
public class CocktailSort {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
       /* boolean swap=true;
        int start=0,end=n;
        while(swap)
        {
            swap=false;
            for(int i=start;i<end-1;i++)
            {

            }
        }*/
        for(int i=0;i<n;i++)
        {
            boolean swap=false;
            for(int j=i;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            System.out.println("From front sort");
            for(int k=0;k<n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
            if(!swap)
            {
                break;
            }
            swap=false;
            for(int j=n-1-i;j>i;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }
            System.out.println("From end sort:");
            for(int k=0;k<n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
            if(!swap)
            {
                break;
            }
        }
        System.out.print("Sorted Array:");
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }
}
