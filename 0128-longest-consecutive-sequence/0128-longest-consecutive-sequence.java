class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int ans = 1;
        for(int num : set){
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len))
                    len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}


/**
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int curr = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1)
                curr++;
            else{
                longest = Math.max(longest, curr);
                curr = 1;
            }
        }
        return Math.max(longest, curr);
    }
}
 */