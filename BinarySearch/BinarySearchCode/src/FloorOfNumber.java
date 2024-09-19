/*
Find a floor of a no.
A floor of a number is a number which is smaller than equal to the target BUT greatest in a list
of all elements which are samller than target.SO.
1.You start your search looking for a element which is smaller than target
(equal found great returned)
2.now lets say you found a smaller element than target at mid ,
now we are checking is it the greatest in the list of all smaller elements.
now tracing ahead in list we are looking for another element if any greater than our current potential ans but
still smaller than target.
3.Basically first check --> smaller mid than element
second check , consider it as potential ans and check ahead : start=mid+1
if any element >currentpoteantial ans && element<target

4.Now why tracing ahead---> its binary search and we are looking for greater element than current (+smaller than target)
But this is tracing condition : "looking for greater element than current"

5.By tracing like this there would be a point where there is only one element in array
s=e=mid, here
1.if mid<target : potential ans, start=mid+1 --> condition violets : ans is end
2.if mid>target : end =mid-1, start>end , condition violets : ans is end

 */
public class FloorOfNumber
{
    public static void main(String [] args)
    {
        System.out.println("--Floor of a no---");
        FloorOfNumber cobj=new FloorOfNumber();
        int arr[]={1,2,3,5,11,15,16,17};
        int target =14;
        System.out.println("floor of a no :"+arr[cobj.floorOfNumber(arr,target)]);

    }
    public int floorOfNumber(int arr[],int target)
    {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        int potentialans=-1;
        /*
            edge case where arr[start]>target
            arr={11,12,13,14,25} target: 10
        */
        if(arr[start]>target)
        {
            return -1;
        }
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]<target)
            {
                potentialans=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;

            }
        }
        return potentialans;
    }
}
