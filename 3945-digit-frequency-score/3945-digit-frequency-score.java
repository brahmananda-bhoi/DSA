class Solution {
    public int digitFrequencyScore(int n) {
        int count =0;
        while(n>0)
        {
            count=count+n%10;
            n=n/10;
        }
        return count;
    }
}