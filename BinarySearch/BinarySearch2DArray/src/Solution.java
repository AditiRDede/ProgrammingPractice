//Kunal Kushwaha's lecture code
/*class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int matrix[][] = {

                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println("Element found :" + obj.searchMatrix(matrix, 7));
    }

}*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        Solution obj=new Solution();


        boolean ans=false;
        int rstart=0;
        int rend=matrix.length-1;
        int midrow=0;
        int cstart=0;
        int cend=matrix[0].length-1;
        int cmid=cstart+(cend-cstart)/2;

        //edge case : if matrix had only one row
        if(matrix.length==1)
        {
            return searchRow(matrix,0,cstart,cend,target);
        }
        while (rstart<(rend-1))
        {
            midrow=rstart+(rend-rstart)/2;
            int midelement=matrix[midrow][cmid];
            if(midelement==target)
            {
                return true;
            }
            else if(midelement<target)
            {
                //skip first half
                //check current row : if found return : else move to next row
                if(searchRow(matrix,midrow,cmid+1,cend,target))
                {
                    return true;
                }
                else
                {
                    rstart=midrow;
                }

            }
            else
            {
                //target is smaller : skip other half
                //check current row : if found return : else : move to previous row
                if(searchRow(matrix,midrow,0,cmid-1,target))
                {
                    return  true;
                }
                else
                {
                    rend=midrow;
                }
            }
        }
        //two rows left

        //check first half mid
        if(matrix[rstart][cmid]==target)
        {

            return true;
        }
        if(matrix[rstart+1][cmid]==target)
        {
            return true;
        }
        else if (matrix[rstart][cmid]>target)
        {
            //check firsthalf

            return searchRow(matrix,rstart,0,cmid,target);
        }
        else if(matrix[rstart][cmid]<target && matrix[rstart][cend]>=target)
        {
            //second half
            return searchRow(matrix,rstart,cmid,cend,target);
        }
        else if( matrix[rstart+1][cmid]>target)
        {
            //check in third half

            return searchRow(matrix,rstart+1,0,cmid,target);
        }
        else
        {
            //check in fourth half

            return searchRow(matrix,rstart+1,cmid,cend,target);
        }


    }
    public boolean searchRow(int matrix [][],int row,int cstart,int cend,int target)
    {
        boolean ans=false;
        int midcol=0;
        int midelement;
        if(cstart<0 ||cend>matrix[0].length)
        {
            return  false;
        }
        while (cstart<=cend)
        {
            midcol=cstart+(cend-cstart)/2;
            midelement=matrix[row][midcol];
            if(midelement==target)
            {
                return  true;
            }
            else if(midelement<target)
            {
                cstart=midcol+1;
            }
            else
            {
                //mid > target : target being smaller
                cend=midcol-1;
            }
        }
        return ans;
    }

}