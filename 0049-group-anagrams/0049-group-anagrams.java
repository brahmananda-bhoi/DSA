class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> ans=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str=new String(chars);
            if(map.containsKey(str)){
                List<String> li=map.get(str);
                li.add(s);
            }
            else{
                List<String> li=new ArrayList<>();
                li.add(s);
                map.put(str, li);
            }
        }
        // for (List<String> group : map.values())
        //     ans.add(group);
        // return ans;
        return new ArrayList<>(map.values());
    }
}