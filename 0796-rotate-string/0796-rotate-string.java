class Solution {
    public boolean rotateString(String s, String goal) {
        int count=0;
        if(s.length()!=goal.length())
            return false;
        for(int i=0;i<goal.length();i++){
            if(!s.contains(goal.charAt(i)+""))
                return false;
        }
        for(int i=0;i<goal.length()-1;i++){
            if(!s.contains(goal.substring(i,i+2)))
                count++;
        }
        return count>1?false:true;


        // if(s.length() != goal.length()) return false;
        // return (s + s).contains(goal);
    }
}