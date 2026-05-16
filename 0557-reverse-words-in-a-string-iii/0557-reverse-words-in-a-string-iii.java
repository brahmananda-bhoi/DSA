class Solution {
    public String reverseWords(String s) {
        String sp[] = s.split(" ");
        StringBuilder reverse = new StringBuilder();
        for(String word : sp){
            StringBuilder rev = new StringBuilder(word);
            rev.reverse();
            reverse.append(rev).append(" ");
        }
        return reverse.toString().trim();
    }
}



// class Solution {
//     public String reverseWords(String s) {
//         Stack<Character> stk = new Stack<>();
//         StringBuilder sb = new StringBuilder();
//         for(char c : s.toCharArray()){
//             if(c == ' '){
//                 while(!stk.isEmpty())
//                     sb.append(stk.pop()+"");
//                 sb.append(" ");
//             }
//             else
//                 stk.push(c);
//         }
//         while(!stk.isEmpty())
//             sb.append(stk.pop()+"");
//         return sb.toString();
//     }
// }