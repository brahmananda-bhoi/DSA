class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> li=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    li.add(1);
                else{
                    List<Integer> temp;
                    temp=ans.get(i-1);
                    li.add(temp.get(j-1)+temp.get(j));
                }
            }
            ans.add(li);
        }
        return ans;
    }
}