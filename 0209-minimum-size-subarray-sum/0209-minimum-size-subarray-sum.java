class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, sum=0, len=Integer.MAX_VALUE;
        while(r<nums.length){
            sum += nums[r];
            while(sum >= target){
                len = Math.min(len, r-l+1);
                sum -= nums[l++];
            }
            r++;
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}

/*
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,length=Integer.MAX_VALUE,sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                length=Math.min(length,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        if(length==Integer.MAX_VALUE)
            return 0;
        else
            return length;
    }
}
*/