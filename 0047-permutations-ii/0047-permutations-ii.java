class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        helper(0, nums, new ArrayList<>(), set);
        return new ArrayList(set);
    }
    private void helper(int index, int[] nums, List<Integer> li, HashSet<List<Integer>> set){
        if(index == nums.length){
            set.add(new ArrayList<>(li));
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(i, index, nums);
            li.add(nums[index]);
            helper(index+1, nums, li, set);
            li.remove(li.size()-1);
            swap(i, index, nums);
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}