class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1, ans;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}





















/*
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,u=nums.length-1;
        int mid=0;
        while(l<=u){
            mid=l+(u-l)/2;
            if(target==nums[mid])
                return mid;
            else if(target>nums[mid]){
                l=mid+1;
            }
            else{
                u=mid-1;
            }
        }
        return u+1;
    }
}
*/