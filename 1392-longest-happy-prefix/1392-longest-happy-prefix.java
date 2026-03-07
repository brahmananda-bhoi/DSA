// class Solution {
//     public String longestPrefix(String s) {
//         int pos=0, base=31;
//         long fhash=0, rhash=0, pow=1;
//         HashMap<Integer, Long> map=new HashMap<>();
//         for(int i=s.length()-1;i>0;i--){
//             int val=s.charAt(i);
//             rhash=rhash+val*pow;
//             map.put(s.length()-i, rhash);
//             pow*=base;
//         }
//         for(int i=0;i<s.length()-1;i++){
//             int val=s.charAt(i);
//             fhash=fhash*base+val;
//             if(fhash==map.get(i+1))
//                 pos=i+1;
//         }
//         return s.substring(0,pos);
//     }
// }



class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        return s.substring(0, lps[n - 1]);
    }
}