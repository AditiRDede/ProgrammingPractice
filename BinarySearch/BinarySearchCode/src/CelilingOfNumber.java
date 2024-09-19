/*Find ceiling of a no
Celing of a number is a number which is greater than or equal to target but it would be smallest in all elements
which are greater than target
*/

public class CelilingOfNumber
{
    public static void main(String args[])
    {
        CelilingOfNumber cobj=new CelilingOfNumber();
        int arr[]={1,2,3,5,11,15,16,17};
        int target =14;
        System.out.println("Ceiling of a no :"+arr[cobj.ceilingNumber(arr,target)]);
        
    }
    public int ceilingNumber(int [] arr,int target)
    {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        int potentialans=0;
        //edge case
        /*
         arr={1,2,3,4,5,6}, target =15
         here no no exisits which is greater than 15

         */
        if(arr[end]<target)
        {
            return -1;
        }
        while(start<=end)
        {
            mid=start +(end-start)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]>target)
            {
                potentialans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;

            }

        }
        return potentialans;
    }
}
