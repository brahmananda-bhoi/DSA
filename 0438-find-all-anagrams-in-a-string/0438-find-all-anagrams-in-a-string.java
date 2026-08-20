class Solution {
    private boolean isAnagram(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap) {
        if (sMap.size() != pMap.size())
            return false;
        for (char c : pMap.keySet()) {
            if (!sMap.containsKey(c) || !sMap.get(c).equals(pMap.get(c)))
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        // Build frequency map for p
        for (char c : p.toCharArray())
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        int windowSize = p.length();
        // Initialize the first window in s
        for (int i = 0; i < windowSize; i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        // Check the first window
        if (isAnagram(sMap, pMap))
            ans.add(0);
        // Slide the window across s
        for (int r = windowSize; r < s.length(); r++) {
            char leftChar = s.charAt(r - windowSize);
            // Remove or decrement count of the leftmost character leaving the window
            sMap.put(leftChar, sMap.get(leftChar) - 1);
            if (sMap.get(leftChar) == 0)
                sMap.remove(leftChar);
            // Add the new character entering the window
            char newChar = s.charAt(r);
            sMap.put(newChar, sMap.getOrDefault(newChar, 0) + 1);
            // Check if current window is an anagram
            if (isAnagram(sMap, pMap))
                ans.add(r - windowSize + 1);
        }
        return ans;
    }
}

/*class Solution {
    private boolean isAnagram(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap) {
        if (sMap.size() != pMap.size())
            return false;
        for (char c : pMap.keySet()) {
            if (pMap.get(c) != sMap.getOrDefault(c, 0))
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : p.toCharArray())
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        int r = 0, l = 0;
        for (; r < p.length(); r++)
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
        for (; r < s.length(); r++) {
            if (isAnagram(sMap, pMap))
                ans.add(l);
            sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            if(sMap.get(s.charAt(l)) <= 0)
                sMap.remove(s.charAt(l));
            l++;
        }
        if (isAnagram(sMap, pMap))
            ans.add(l);
        return ans;
    }
}*/