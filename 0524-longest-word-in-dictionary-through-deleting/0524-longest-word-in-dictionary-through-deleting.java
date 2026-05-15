class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) ->{
            int length = Integer.compare(s2.length(), s1.length());
            if(length != 0)
                return length;
            return s1.compareTo(s2);
        });
        for(int i = 0; i < dictionary.size(); i++){
            String str = dictionary.get(i);
            if(str.length() > s.length())
                continue;
            int sIndex = 0, strIndex = 0;
            while(sIndex < s.length() && strIndex < str.length()){
                if(s.charAt(sIndex) == str.charAt(strIndex))
                    strIndex++;
                sIndex++;
            }
            if(strIndex == str.length())
                return str;
        }
        return "";
    }
}