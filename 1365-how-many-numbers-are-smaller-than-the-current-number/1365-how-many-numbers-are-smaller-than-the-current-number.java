class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] count=new int[101];//constrain 0 <= nums[i] <= 100
        for(int num:nums)
            count[num]++;
        for(int i=1;i<=100;i++)
            count[i]+=count[i-1];
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                result[i]=0;
            else
                result[i]=count[nums[i]-1];
        }
        return result;
    }
}