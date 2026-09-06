class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int a, b;
        for(String s : tokens){
            if(s.equals("+")){
                a=stk.pop();
                b=stk.pop();
                stk.push(a+b);
            }
            else if(s.equals("-")){
                a=stk.pop();
                b=stk.pop();
                stk.push(b-a);
            }
            else if(s.equals("*")){
                a=stk.pop();
                b=stk.pop();
                stk.push(a*b);
            }
            else if(s.equals("/")){
                a=stk.pop();
                b=stk.pop();
                stk.push(b/a);
            }
            else
                stk.push(Integer.parseInt(s));
        }
        return stk.peek();
    }
}




/*
class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stk=new Stack<>();
        int res=0,a,b;
        for(String c : tokens){
            if(c.matches("-?\\d+")){
                stk.push(Integer.parseInt(c));
            }
            else{
                a=stk.pop();
                b=stk.pop();
                switch (c) {
                    case "+":
                        res =  b + a; 
                        break;
                    case "-": 
                        res =  b - a; 
                        break;
                    case "*": 
                        res =  b * a; 
                        break;
                    case "/": 
                        res =  b / a; 
                        break;
                }
                stk.push(res);
            }
        }
        return stk.pop();
    }
}
*/