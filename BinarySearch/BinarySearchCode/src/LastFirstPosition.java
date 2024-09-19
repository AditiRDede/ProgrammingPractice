/*
You have given sorted array where your task is to find the first position of element and last position of element
 arr={6,7,7,7,7,9,8,10}
 find the mid :: potential ans
 search for first half for first position end=mid-1 : at loopbreak condition : already had the potential ans
 search for secong half for second position start=mid+1 : at loopbreak condition " :already had the potential ans



 */
import java.util.Arrays;
public class LastFirstPosition
{
    public static void main(String [] args)
    {
        System.out.println("Find the first and last position of an element in sorted array");
        int arr []={6,7,7,7,7,9,8,10};
        int target=7;
        int ans[]={-1,-1};
        LastFirstPosition obj=new LastFirstPosition();
        ans[0]=obj.search(arr,target,true);
        if(ans[0]!=-1)
        {
            ans[1]= obj.search(arr,target,false);
        }
        System.out.println("Ans array is : "+Arrays.toString(ans));


    }
    public int search(int arr[],int target,boolean firstoccurance)
    {
        int start=0;
        int end =arr.length-1;
        int mid=0;
        int potentialans=-1;
        while(start<=end)
        {
            //find the element
            mid=start+(end-start)/2;
            if(arr[mid]<target)
            {
                start=mid+1;
            }else if(arr[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                //now you have found the mid ::check first and last occurance
                potentialans=mid;
                if(firstoccurance)
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
        }
        return potentialans;

    }
}
