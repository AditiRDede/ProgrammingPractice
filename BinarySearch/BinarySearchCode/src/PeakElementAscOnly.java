public class PeakElementAscOnly
{
    public static void main(String [] args)
    {
        System.out.println("Find peak element when all elements are ascending");
        //int arr[]={1,2,1,3,5,6,4};
        int arr[]={1,2};
        PeakElementAscOnly obj=new PeakElementAscOnly();
        int ans=obj.peakElement(arr,true);
        if(ans==-1)
        {
            ans=obj.peakElement(arr,false);
        }
        System.out.println("peak element index is : "+ans);
    }
    public int peakElement(int arr[],boolean otherhalf)
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
                    return mid;

                }
                if(mid !=0 && arr[mid-1]>arr[mid])
                {
                    return mid-1;
                }

                else if(otherhalf)
                {


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

