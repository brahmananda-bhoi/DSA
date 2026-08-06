class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int fre=0, l=0, r=0, len=0;
        while(r < s.length()){
            char c = s.charAt(r);
            arr[c-'A']++;
            fre = Math.max(fre, arr[c-'A']);
            if((r-l+1) <= fre+k)
                len = Math.max(len, r-l+1);
            else{
                arr[s.charAt(l++)-'A']--;
            }
            r++;
        }
        return len;
    }
}