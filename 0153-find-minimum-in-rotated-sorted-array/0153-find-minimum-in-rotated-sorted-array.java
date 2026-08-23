class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        if(nums[l] <= nums[r])
            return nums[l];
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid > 0 && nums[mid]<nums[mid-1])
                return nums[mid];
            if(mid < nums.length-1 && nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid] > nums[l])
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}













/*
class Solution {
    public int findMin(int[] nums) {
        int l=0,u=nums.length-1;
        if (nums[l] <= nums[u])
            return nums[l];
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid] > nums[l])
                l = mid + 1;
            else
                u = mid - 1;
        }
        return -1;
    }
}
*/