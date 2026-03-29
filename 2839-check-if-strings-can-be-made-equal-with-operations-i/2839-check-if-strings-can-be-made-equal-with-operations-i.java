class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        StringBuilder sb1=new StringBuilder(s1);
        swap(sb1, 0, 2);
        if(s2.equals(sb1.toString()))
            return true;
        swap(sb1, 1, 3);
        if(s2.equals(sb1.toString()))
            return true;
        sb1=new StringBuilder(s1);
        swap(sb1, 1, 3);
        if(s2.equals(sb1.toString()))
            return true;
        return false;
    }
    private void swap(StringBuilder sb, int i, int j){
        char c=sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }
}