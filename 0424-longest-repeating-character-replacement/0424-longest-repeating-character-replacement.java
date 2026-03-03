class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,len=0,fre=0;
        int hash[]=new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            fre=Math.max(fre,hash[s.charAt(r)-'A']);
            if((r-l+1)-fre>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-fre<=k)
                len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}