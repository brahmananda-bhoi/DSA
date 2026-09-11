class Solution {
    private int solve(int i, int n, int[] costs, int[] dp){
        if(i == n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int minCost=Integer.MAX_VALUE;
        for(int j=1; j<4; j++){
            int jump = i+j;
            if(jump <= n){
                int cost = costs[jump-1]+((jump-i)*(jump-i));
                int pathCost = cost + solve(jump, n, costs, dp);
                minCost=Math.min(minCost, pathCost);
            }
        }
        dp[i]=minCost;
        return minCost;
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs, dp);
    }
}