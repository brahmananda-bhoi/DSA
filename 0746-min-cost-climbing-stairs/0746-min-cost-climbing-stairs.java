class Solution {
    private int solve(int i, int[] cost, int[] dp){
        if(i == cost.length-1)
            return cost[cost.length-1];
        if(dp[i] != -1)
            return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j=1; j<3; j++){
            int index = i+j;
            int pathCost=0;
            if(index <= cost.length){
                pathCost = cost[i] + solve(index, cost, dp);
            }
            minCost = Math.min(minCost, pathCost);
        }
        dp[i] = minCost;
        return minCost;
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }
}


/*
class Solution {
    private int solve(int i, int[] cost){
        if(i == cost.length-1)
            return cost[cost.length-1];
        int minCost = Integer.MAX_VALUE;
        for(int j=1; j<3; j++){
            int index = i+j;
            int pathCost=0;
            if(index <= cost.length){
                pathCost = cost[i] + solve(index, cost);
            }
            minCost = Math.min(minCost, pathCost);
        }
        return minCost;
    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(0, cost), solve(1, cost));
    }
}
*/