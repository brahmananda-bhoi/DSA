class Solution {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }
        return n - 999;
    }
}

/*
class Solution {
    public int countCommas(int n) {
        if(n<1000)
            return 0;
        int ans=0;
        for(int i=1000; i<=n;i++){
            ans += Math.log10(n)/3;
        }
        return ans;
    }
}
*/