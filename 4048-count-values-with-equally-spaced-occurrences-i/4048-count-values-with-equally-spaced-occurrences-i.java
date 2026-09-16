class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            else
                map.get(nums[i]).add(i);
        }
        int ans=0;
        for(int key : map.keySet()){
            if(map.get(key).size() == 3){
                if(map.get(key).get(1) - map.get(key).get(0) == map.get(key).get(2) - map.get(key).get(1))
                    ans++;
            }
        }
        return ans;
    }
}