class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums.length==2)
            return (nums[0]>nums[1])?0:1;
        int l=0,u=nums.length-1;
        int mid=0;
        while(l<=u){
            mid=l+(u-l)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
                return mid;
            else if(nums[mid]<nums[mid+1])
                l=mid+1;
            else
                u=mid-1;
        }
        return u;
    }
}