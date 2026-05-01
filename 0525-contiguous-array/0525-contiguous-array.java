class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //key : prefix sum, value : index
        int sum = 0, length = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)){
                int index = map.get(sum);
                length = Math.max(length, i - index);
            }
            else
                map.put(sum, i);
        }
        return length;
    }
}