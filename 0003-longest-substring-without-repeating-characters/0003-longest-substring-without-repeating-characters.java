class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0, l=0, r=0;
        HashSet<Character> set=new HashSet<>();
        while(r<s.length()){
            char ch=s.charAt(r);
            if(!set.add(ch)){
                while(s.charAt(l)!=ch)
                    set.remove(s.charAt(l++));
                l++;
            }
            len=Math.max(len, set.size());
            r++;
        }
        return len;
    }
}