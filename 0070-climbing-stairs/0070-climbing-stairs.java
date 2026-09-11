class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int prev1 = 2; // Ways to reach step 2
        int prev2 = 1; // Ways to reach step 1
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}

/*
class Solution {
    private int solve(int n, int index, int[] memo){
        if (index == n) return 1;
        if (index > n) return 0;
        // Return the cached result if we've already calculated this index
        if (memo[index] > 0) {
            return memo[index];
        }
        // Calculate and cache the result
        memo[index] = solve(n, index + 1, memo) + solve(n, index + 2, memo);
        return memo[index];
    }
    
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return solve(n, 0, memo);
    }
}
*/

/*class Solution {
    int ans=0;
    private void solve(int n, int index){
        if(index == n)
            ans++;
        if(index >= n)
            return;
        solve(n, index+1);
        solve(n, index+2);
    }
    public int climbStairs(int n) {
        solve(n, 0);
        return ans;
    }
}*/