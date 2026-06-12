class Solution {
    private void helper(int index, int[] nums, Set<List<Integer>> set, List<Integer> li){
        if(li.size() >= 2)
            set.add(new ArrayList<>(li));
        for(int i=index; i<nums.length; i++){
            if(li.size() == 0 || li.get(li.size()-1) <= nums[i]){
                li.add(nums[i]);
                helper(i+1, nums, set, li);
                li.remove(li.size()-1);
            } 
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        helper(0, nums, set, new ArrayList<>());
        return new ArrayList(set);
    }
}