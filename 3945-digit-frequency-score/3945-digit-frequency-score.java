class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = n;
        while(temp > 0){
            int digit = temp%10;
            temp /= 10;
            map.put(digit, map.getOrDefault(digit,0)+1);
        }
        int ans=0;
        for(int key : map.keySet())
            ans += key * map.get(key);
        return ans;
    }
}