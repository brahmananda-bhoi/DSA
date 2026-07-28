class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        int[] arr = new int[26];
        char[] ans = new char[n];
        for(char c : s.toCharArray())
            arr[c-'a']++;
        int i=0, j=0, mid=n/2;
        while(i<26 && j<mid){
            while(arr[i] > 1){
                ans[j] = (char)(i+'a');
                ans[n-j-1] = (char)(i+'a');
                arr[i] -= 2;
                j++;
            }
            i++;
        }
        if(n%2 == 1){
            for(int k=0; k<26;k++){
                if(arr[k] == 1){
                    ans[mid]=(char)(k+'a');
                    break;
                }
            }
        }
        return new String(ans);
    }
}