class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = new int[]{-1, -1, -1};
        int ans=0;
        for(int i=0; i<s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            int min = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            ans += min+1;
        }
        return ans;
    }
}
/**
class Solution {
    public int numberOfSubstrings(String s) {
        int lastseen[]={-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            lastseen[s.charAt(i)-'a']=i;
            int min=Math.min(lastseen[0],lastseen[1]);
            min=Math.min(min,lastseen[2]);
            count+=1+min;
        }
        return count;
    }
}
 */