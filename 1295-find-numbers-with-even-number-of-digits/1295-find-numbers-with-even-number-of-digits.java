class Solution {
    public int findNumbers(int[] nums) {
        int ans =0;
        for(int x : nums){
            int temp = (int)(Math.log10(x)+1) % 2 == 0 ? 1 : 0;
            ans += temp;
        }
        return ans;
    }
}