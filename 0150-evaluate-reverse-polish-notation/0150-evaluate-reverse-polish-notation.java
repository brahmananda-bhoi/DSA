class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        String str="+-*/";
        for(String s:tokens){
            if(str.contains(s)){
                int right=stk.pop();
                int left=stk.pop();
                switch(s){
                    case "+":
                        stk.push(left+right);
                        break;
                    case "-":
                        stk.push(left-right);
                        break;
                    case "*":
                        stk.push(left*right);
                        break;
                    case "/":
                        stk.push(left/right);
                        break;
                }
            }
            else
                stk.push(Integer.parseInt(s));
        }
        return stk.pop();
    }
}