public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Binary search in 2D array");
        Main obj=new Main();
        /*int matrix[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };*/
        /*int matrix[][]=  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};*/
        int matrix[][]={
                {1}

        };

        //SearchRow --> binary search on midrow
        //searchMatrix-->entire matrix
        System.out.println("element exists :"+obj.searchMatrix(matrix,1));
    }
    boolean searchMatrix(int matrix[][],int target)
    {
        boolean ans=false;
        int cstart=0;
        int cend=matrix[0].length-1;
        int midcol=(cend + cstart) / 2;
        int midrow=0;
        int rstart=0;
        int rend=matrix.length-1;

        while(rstart<=rend)
        {
            //set midrow
            midrow=rstart+(rend-rstart)/2;
            int midelement=matrix[midrow][midcol];
            if(midelement==target)
            {
               ans=true;
               break;
            }
            else if(midelement<target)
            {
                //check that row from cmid+1 till lastcol

                if(searchRow(matrix,midrow,midcol+1,cend,target))
                {
                    ans=true;
                    break;
                }
                else
                {
                    rstart=midrow+1;
                }

            }
            else
            {
                //midelement>target

                if(searchRow(matrix,midrow,0,midcol-1,target))
                {
                    ans=true;
                    break;
                }
                else
                {
                    rend=midrow-1;
                }
            }
        }



        return ans;
    }

    boolean searchRow(int matrix[][],int row,int cstart,int cend,int target)
    {
        boolean ans=false;

        if(cstart<0 || cend >matrix[0].length)
        {
            return false;
        }
        int mid=0;
        while (cstart<=cend)
        {
            mid=cstart+(cend-cstart)/2;
            if(matrix[row][mid]==target)
            {
                return true;
            }else if(matrix[row][mid]<target)
            {
                cstart=mid+1;

            }
            else
            {
                cend=mid-1;
            }
        }
        return ans;
    }
}