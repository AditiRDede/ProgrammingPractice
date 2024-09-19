public class WorkingPeak
{
    public static void main(String [] args)
    {
        System.out.println("Find peak element when all elements are ascending");
        int arr[]={1,2,1,3,5,6,7};
        WorkingPeak obj=new WorkingPeak();
        int ans=obj.peakElement(arr);
        if(ans==-1)
        {
            ans=obj.peakElement(arr);
        }
        System.out.println("peak element index is : "+ans);
    }
    public int peakElement(int arr[])
    {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        int potentialans=-1;
        while(start<end)
        {
            mid=start+(end-start)/2;
            //check if element is pivot
            //mid+1!=end+1 &&
            if( arr[mid]>arr[mid+1])
            {
                // return mid;
                end=mid;
            }
            else
            {
                start=mid+1;
            }
            /*else if( mid>=0 && arr[mid-1]>arr[mid])
            {
                //mid-1!=-1 &&
               // return mid-1;
                start=mid;
            }
            else
            {
                //pivot didnt found and we are in normal sorted array
                //first check other half
                if(otherhalf)
                {
                    mid=start+1;
                }
                else
                {
                    mid=end-1;
                }
*/
        }
        return start;
    }

}

