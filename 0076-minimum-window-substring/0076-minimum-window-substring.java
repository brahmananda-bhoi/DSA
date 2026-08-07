class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            char endChar = chS[end];
            if (map.containsKey(endChar) && map.get(endChar) > 0)
                count--;
            // Decrease the count in the map for the current character
            map.put(endChar, map.getOrDefault(endChar, 0) - 1);
            end++;
            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }
                char startChar = chS[start];
                // Increment the count in the map for the character at start
                map.put(startChar, map.getOrDefault(startChar, 0) + 1);
                if (map.get(startChar) > 0) {
                    count++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : new String(chS, startIndex, minLen);
    }
}



// class Solution {
//     private boolean match(Map<Character, Integer> tmap, Map<Character, Integer> smap){
//         for(char c : tmap.keySet()){
//             if(tmap.get(c) > smap.get(c))
//                 return false;
//         }
//         return true;
//     }
//     public String minWindow(String s, String t) {
//         if(t.length() > s.length())
//             return "";
//         Map<Character, Integer> tmap = new HashMap<>();
//         Map<Character, Integer> smap = new HashMap<>();
//         for(char c : t.toCharArray())
//             tmap.put(c, tmap.getOrDefault(c,0)+1);
//         int l=0, r=0, start=0, len=Integer.MAX_VALUE;
//         while(r<s.length()){
//             char c = s.charAt(r);
//             smap.put(c, smap.getOrDefault(c, 0)+1);
//             if(match(tmap, smap)){
//                 len = r++;
//                 break;
//             }
//             r++;
//         }
        
//     }
// }



/*
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
}
*/