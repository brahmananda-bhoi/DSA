class Solution {
    private boolean isLetter(char c){
        return c >= 'a' && c <= 'z';
    }
    private void extractWords(String s, Map<String, Integer> wordCount){
        int n = s.length();
        int i = 0;
        while(i < n){
            if(!isLetter(s.charAt(i))){
                i++;
                continue;
            }
            StringBuilder word = new StringBuilder();
            word.append(s.charAt(i++));
            while(i < n){
                char c = s.charAt(i);
                if(isLetter(c)){
                    word.append(c);
                    i++;
                }
                else if(c == '-' && i + 1 < n && isLetter(s.charAt(i + 1))){
                    word.append(c);
                    i++;
                }
                else
                    break;
            }
            String w = word.toString();
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
    }
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for(String chunk : chunks)
            sb.append(chunk);
        String s = sb.toString();
        Map<String, Integer> wordCount = new HashMap<>();
        extractWords(s, wordCount);
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++)
            ans[i] = wordCount.getOrDefault(queries[i], 0);
        return ans;
    }
}