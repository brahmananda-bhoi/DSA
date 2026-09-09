class Solution {
    public long countCommas(long n) {
        // if(n<1000)
        //     return 0;
        long ans=0, val=n;
        // for(int i=1000; i<=n;i *= 10){
        //     int digit=(int)Math.log10(i)/3;
        //     int temp=i*10;
        //     if(temp<=n){
        //         ans += (digit * (temp-i));
        //     }
        //     ans += (digit * (n-i+1));
        // }
        for(int i=1; i<=5;i++){
            long lower = (long)Math.pow(10, 3*i);
            long upper = (long)Math.pow(10, 3*(i+1))-1;
            if(val < lower)
                break;
            long count = Math.min(val, upper) - lower+1;
            ans += (count*i);
        }
        return ans;
    }
}