class Solution {
    public int minimumDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer>b=map.get(nums[i]);
                b.add(i);
                map.put(nums[i],b);
                if(b.size()>3)
                    b.remove(0);
                if(b.size()==3)
                {
                    int c=Math.abs(b.get(0)-b.get(1))+
                    Math.abs(b.get(1)-b.get(2))+
                    Math.abs(b.get(2)-b.get(0));
                    if(c<ans)
                        ans=c;
                }
            }
            else{
                List<Integer> li=new ArrayList<>();
                li.add(i);
                map.put(nums[i], li);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}