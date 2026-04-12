class Solution {
    private int squareRoot(int num){
        if(0 == num || 1 == num)
            return num;
        int l=1, r=num, mid, ans=0;
        long mul=1;
        while(l<=r){
            mid=l+(r-l)/2;
            mul = (long)mid * mid;
            if(mul == num)
                return mid;
            else if(mul > num)
                r = mid-1;
            else{
                l = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
    public boolean isPerfectSquare(int num) {
        long x = squareRoot(num);
        return x*x == num;
    }
}