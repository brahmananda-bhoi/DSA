class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int num : nums){
            if(num <= 9)
                li.add(num);
            else{
                String s = num+"";
                for(int i = 0; i<s.length(); i++)
                    li.add(Integer.parseInt(s.charAt(i)+""));
            }
        }
        int n = li.size();
        int[] ans = new int[n];
        for(int i=0; i<n; i++)
            ans[i] = li.get(i);
        return ans;
    }
}