class Solution {
    public int passwordStrength(String password) {
        Set<Character> set=new HashSet<>();
        for(char c:password.toCharArray())
            set.add(c);
        int ans=0;
        for(char c:set){
            if(c >= 65 && c <= 90)
                ans +=2;
            else if(c >= 97 && c <= 122)
                ans++;
            else if(c >= 48 && c<= 57)
                ans += 3;
            else
                ans += 5;
        }
        return ans;
    }
}