class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : text.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        int b=0, a=0, l=0, o=0, n=0;
        b = map.getOrDefault('b',0);
        a = map.getOrDefault('a',0);
        l = map.getOrDefault('l',0)/2;
        o = map.getOrDefault('o',0)/2;
        n = map.getOrDefault('n',0);
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, b);
        ans = Math.min(ans, a);
        ans = Math.min(ans, l);
        ans = Math.min(ans, o);
        ans = Math.min(ans, n);
        return ans;
    }
}