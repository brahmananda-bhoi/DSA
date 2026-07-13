class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int replaced = 0, notReplaced = 0, index = 0;
        boolean isUsed = false;
        while (index < t.length() && replaced<s.length() && notReplaced<s.length()) {
            if (t.charAt(index) == s.charAt(replaced) || !isUsed)
                replaced++;
            if (t.charAt(index) == s.charAt(notReplaced))
                notReplaced++;
            isUsed = replaced != notReplaced;
            index++;
        }
        return replaced==s.length() || notReplaced==s.length();
    }
}


/*
class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length();
        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            j = Math.max(j + (j < n && c == s.charAt(j) ? 1 : 0), i + 1);
            i += (i < n && c == s.charAt(i) ? 1 : 0);
        }
        return j >= n;
    }
}
*/

    
/**
class Solution {
    private boolean isSubsequence(String s, String t){
        int index=0, j=0;
        for(int i=0; i<t.length() && index < s.length(); i++){
            if(s.charAt(index) == t.charAt(i)){
                index++;
                j=i;
            }
        }
        if(index == s.length())
            return true;
        else if(j != t.length()-1){
            index++;
            for(int i=j+1; i<t.length() && index < s.length(); i++){
                if(s.charAt(index) == t.charAt(i))
                    index++;
            }
        }
        return index == s.length();
    }
    public boolean canMakeSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;
        int n = s.length();
        if(isSubsequence(s, t))
            return true;
        return false;
    }
}
 */