class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<accounts.length; i++){
            int sum = 0;
            for(int x : accounts[i])
                sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}