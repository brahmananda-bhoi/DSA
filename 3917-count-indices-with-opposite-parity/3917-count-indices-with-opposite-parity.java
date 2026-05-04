class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // for(int i=0; i<n; i++){
        //     int count= 0;
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i]%2 != nums[j]%2)
        //             count++;
        //     }
        //     ans[i]=count;
        // }
        int odd=0, even=0;
        for(int i=n-1; i>=0; i--){
            if(nums[i]%2 == 0){
                even++;
                ans[i] = odd;
            }
            else{
                odd++;
                ans[i] = even;
            }
        }
        return ans;
    }
}