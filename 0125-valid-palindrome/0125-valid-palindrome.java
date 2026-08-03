class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer temp= new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                temp.append(Character.toLowerCase(c));
            }
        }
        int i=0,j=temp.length()-1;
        while(i<j){
            if(temp.charAt(i)!=temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;   
    }
}