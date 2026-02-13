class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans=new ArrayList<>();
        int cur[]=intervals[0];
        ans.add(cur);
        for(int i=1;i<intervals.length;i++){
            int interval[]=intervals[i];
            if(cur[1]>=interval[0])
                cur[1]=Math.max(cur[1],interval[1]);
            else{
                cur=interval;
                ans.add(interval);
            }
        }
        return ans.toArray(new int[0][]);
    }
}