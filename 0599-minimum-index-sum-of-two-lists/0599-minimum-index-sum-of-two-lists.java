class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            for(int j=0; j<list2.length; j++){
                if(list1[i].equals(list2[j])){
                    if(!map.containsKey(i+j))
                        map.put(i+j, new ArrayList<>());
                    map.get(i+j).add(list1[i]);
                    break;
                }
            }
        }
        int temp=Integer.MAX_VALUE;
        for(int i : map.keySet())
            temp = Math.min(temp, i);
        String[] ans = new String[map.get(temp).size()];
        int i=0;
        for(String s : map.get(temp))
            ans[i++] = s;
        return ans;
    }
}