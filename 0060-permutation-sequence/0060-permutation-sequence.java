class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> li=new ArrayList<>();
        for(int i=1; i<n; i++){
            fact*=i;
            li.add(i);
        }
        li.add(n);
        StringBuilder ans= new StringBuilder();
        k--;
        while(true){
            ans.append(li.get(k/fact)+"");
            li.remove(k/fact);
            if(li.size() == 0)
                break;
            k=k%fact;
            fact = fact/li.size();
        }
        return ans.toString();
    }
}