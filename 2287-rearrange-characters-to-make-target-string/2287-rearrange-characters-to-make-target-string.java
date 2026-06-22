class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : s.toCharArray())
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        for(char c : target.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        int ans = Integer.MAX_VALUE;
        for(char c: tMap.keySet()){
            ans = Math.min(ans, sMap.getOrDefault(c, 0)/tMap.get(c));
            if(ans == 0)
                return 0;
        }
        return ans;
    }
}