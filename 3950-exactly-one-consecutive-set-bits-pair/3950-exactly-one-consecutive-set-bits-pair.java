class Solution {
    public boolean consecutiveSetBits(int n) {
        int count=0, temp=n, prev=0;
        while(temp > 0){
            if(temp%2 == 1){
                if(prev == 1){
                    if(count == 1)
                        return false;
                    count++;
                }
            }
            prev=temp%2;
            temp >>=1;
        }
        return count == 1;
    }
}