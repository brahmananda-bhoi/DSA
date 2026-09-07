class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] parts = path.split("/");
        for(String part : parts){
            if(part.equals("") || part.equals("."))
                continue;
            else if(part.equals("..")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else
                stk.push(part);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : stk)
            sb.append("/").append(s);
        return sb.length()==0?"/":sb.toString();
    }
}



/*
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; // Ignore empty and current directory
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go one level up
                }
            } else {
                stack.push(part); // Valid directory name
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
*/