// class Solution {
//     public long minOperations(int[] nums) {
//         long ans = 0, cur = 0;
//         for(int i=0; i<nums.length-1; i++){
//             if(nums[i] > nums[i+1]){
//                 long diff;
//                 if(nums[i] > nums[i+1] + cur){
//                     diff = nums[i] - nums[i+1] - cur;
//                     cur += diff;
//                     ans += diff;
//                 }
//                 nums[i+1] += cur;
//             }
//             else
//                 cur=0;
//         }
//         return ans;
//     }
// }



class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                ans += nums[i] - nums[i + 1];
            }
        }
        return ans;
    }
}