class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length, col=matrix[0].length;
        int l=0, r=row*col-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[mid/col][mid%col] == target)
                return true;
            else if(matrix[mid/col][mid%col] > target)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}
























/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length,c=matrix[0].length;
        int l=0,u=r*c-1;
        int mid=0;
        while(l<=u){
            mid=l+(u-l)/2;
            if(matrix[mid/c][mid%c]==target)
                return true;
            else if(matrix[mid/c][mid%c]>target){
                u=mid-1;
            }
            else
                l=mid+1;
        }
        return false;
    }
}
*/