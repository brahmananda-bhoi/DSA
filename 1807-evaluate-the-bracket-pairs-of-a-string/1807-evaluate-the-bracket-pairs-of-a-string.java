class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge)
            map.put(pair.get(0), pair.get(1));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (s.charAt(j) != ')')
                    j++;
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key, "?"));
                i = j + 1;
            }
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}




/*
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> li : knowledge)
            map.put(li.get(0), li.get(1));
        // System.out.println(map.keySet());
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            if(s.charAt(i) == '('){
                StringBuilder str = new StringBuilder();
                i++;
                while(s.charAt(i) != ')'){
                    str.append(s.charAt(i)+"");
                    i++;
                }
                // System.out.println("--"+str+"--");
                // System.out.println("--"+map.get(str)+"--");
                // System.out.println(map.containsKey(str));
                sb.append(map.getOrDefault(str.toString(), "?"));
            }
            else
                sb.append(s.charAt(i)+"");
            i++;
        }
        return sb.toString();
    }
}
*/