import java.util.*;
public class BinarySearch
{
    public static void main(String [] args)
    {
        System.out.println("Binary Search...");
        Scanner input =new Scanner(System.in);
        int target=0;
        //sorted array
        //int array[]={11, 12,13,14,15,36,88,90};
        int array [] =new int[10];
        System.out.println("Enter sorted array elements:");
        for(int i=0;i<array.length;i++)
        {
            array[i]=input.nextInt();
        }
        System.out.println("Array :"+Arrays.toString(array));
        System.out.println("Enter an element to search :");
        target =input.nextInt();


        int ans=BinarySearchAlgo(array,target);
        System.out.println("Element found at index :"+ans);

    }
    public static int BinarySearchAlgo(int arr[],int target)
    {
        int start=0;
        int end=arr.length-1;

        while(start<=end)
        {
           // int mid=start+(end-start)/2;
            int mid=(start+end)/2;
            if(target<arr[mid])
            {
                end=mid-1;

            }
            else if(target>arr[mid])
            {
                start=mid+1;

            }else
            {
                return mid;
            }
        }
        return -1;
    }
}
