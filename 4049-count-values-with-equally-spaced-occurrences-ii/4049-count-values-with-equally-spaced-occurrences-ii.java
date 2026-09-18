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
            if(map.get(key).size() >= 3){
                List<Integer> li = map.get(key);
                int diff = li.get(1) - li.get(0);
                boolean flag=true;
                for(int i=2; i<li.size(); i++){
                    if(diff != li.get(i)-li.get(i-1)){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    ans++;
            }
        }
        return ans;
    }
}