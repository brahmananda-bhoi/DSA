class Solution {
    public int countKthRoots(int l, int r, int k) {
        return solve(r, k) - solve(l - 1, k);
    }
    int solve(int n, int k) {
        if (n < 0) return 0;
        int l = 0, r = n, ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (pow(m, k) <= n) {
                ans = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        return ans + 1;
    }
    long pow(long b, int e) {
        long res = 1;
        while (e-- > 0) {
            if (b != 0 && res > 1_000_000_000L / b)
                return Long.MAX_VALUE;
            res *= b;
        }
        return res;
    }
}



// class Solution {
//     public int countKthRoots(int l, int r, int k) {
//         int temp = 1, count=0;
//         for(long x=0;;x++){
//             long p=pow(x, k);
//             if(p>r)break;
//             if(p>= l)
//                 count++;
//         }
//         return count;
//     }
//     private long pow(long base, int exp){
//         if(base == 0)
//             return 0;
//         long res=1;
//         for(int i=0; i<exp;i++){
//             if(res > 1000000000L /base)
//                 return Long.MAX_VALUE;
//             // if(res > 1e9 /base)
//             //     return Long.MAX_VALUE;
//             res *= base;
//         }
//         return res;
//     }
// }