//My approach : for 2D search
public class WorkingCode {
    public boolean searchMatrix(int[][] matrix, int target) {
        Solution obj=new Solution();
        boolean ans=false;
        // int midcol=matrix[0].length/2;
        int cstart=0;
        int cend=matrix[0].length-1;
        int midcol=(cend + cstart) / 2;
        int midrow=0;
        int rstart=0;
        int rend=matrix.length-1;
        if(matrix.length==1)
        {
            return searchRow(matrix,0,0,cend,target);
        }
        while(rstart<=rend)
        {
            //set midrow
            //midrow=rstart+(rend-rstart)/2;
            midrow=(rstart+rend)/2;
            int midelement=matrix[midrow][midcol];
            if(midelement==target)
            {
                ans=true;
                break;
            }
            else if(midelement<target)
            {
                //check that row from cmid+1 till lastcol
                if(obj.searchRow(matrix,midrow,midcol+1,cend,target))
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
                if(obj.searchRow(matrix,midrow,0,midcol-1,target))
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
    public  boolean searchRow(int matrix[][],int row,int cstart,int cend,int target)
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
