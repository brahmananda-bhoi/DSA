class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return new String(sArray).equals(new String(tArray));
    }
}

/**
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length())
            return false;
        for(char c : s.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        for(char c : t.toCharArray()){
            if(map.containsKey(c) && map.get(c)!=0)
                map.put(c,map.get(c)-1);
            else
                return false;
        }
        return true;
    }
}
 */