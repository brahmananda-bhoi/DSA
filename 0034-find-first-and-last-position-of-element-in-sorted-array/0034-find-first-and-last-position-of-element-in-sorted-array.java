class Solution {
    private int findLeft(int[] nums, int target, int l, int r){
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid] == target){
                res=mid;
                r=mid-1;
            }
            else if(nums[mid] > target)
                r=mid-1;
            else
                l=mid+1;
        }
        return res;
    }
    private int findRight(int[] nums, int target, int l, int r){
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid] == target){
                res=mid;
                l=mid+1;
            }
            else if(nums[mid] > target)
                r=mid-1;
            else
                l=mid+1;
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=findLeft(nums, target, 0, nums.length-1);
        res[1]=findRight(nums, target, 0, nums.length-1);
        return res;
    }
}