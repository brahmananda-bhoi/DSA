class Solution {
    public int reverse(int x) {
        long ans = 0;
        int sign = 1;
        if(x < 0){
            sign = -1;
            x *= -1;
        }
        while(x > 0){
            ans *= 10;
            ans += x % 10;
            x /= 10;
        }
        return ans > Integer.MAX_VALUE ? 0 : (int) ans * sign;
    }
}