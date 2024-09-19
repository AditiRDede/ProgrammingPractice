/*
Find letter in array which is greater than target but smallest in list
this is basically finding ceiling letter.
here in the question they added one condition that letters wrap around.
if arr={'a','b'}, target='z' :: ans -->a
basically if arr[end]<taget, return arr[0]
 a,b,c.....z,a , b ,
*/
public class GreaterLetterSmallest
{
    public static void main(String [] args)
    {
        System.out.println("Smallest letter ");
        GreaterLetterSmallest obj=new GreaterLetterSmallest();
        char letters []={'c','f','j'};
        char ans=obj.nextGreatestLetter(letters,'g');
        System.out.println("greateslettersmallest : "+ans );
    }
    public char nextGreatestLetter(char[] letters, char target)
    {
        char ans='\0';

        int start=0;
        int end=letters.length-1;
        int mid=0;
        //edge case :: as letters wrap around
        if(letters[end]<=target)
        {
            return letters[start];
        }

        while (start<=end)
        {
            mid=start+(end-start)/2;
            if(letters[mid]>target)
            {
                ans=letters[mid];
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }

        return ans;
    }
}
