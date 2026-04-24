class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
                five++;
            else if(bills[i]==10){
                ten++;
                five--;
            }
            else if(ten>0){
                ten--;
                five--;
            }
            else 
                five-=3;
            if(five<0)
                return false;
        }
        return true;
    }
}





// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         if(bills[0] != 5)
//             return false;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         map.put(5, 1);
//         map.put(10, 0);
//         for(int i=1; i<bills.length; i++){
//             if(bills[i] == 5)
//                 map.put(5, map.get(5)+1);
//             else if(bills[i] == 10){
//                 map.put(10, map.get(10)+1);
//                 if(map.get(5) == 0)
//                     return false;
//                 else
//                     map.put(5, map.get(5)-1);
//             }
//             else{
//                 if(map.get(5) == 0)
//                     return false;
//                 if(map.get(10) != 0){
//                     map.put(10, map.get(10)-1);
//                     map.put(5, map.get(5)-1);
//                 }
//                 else{
//                     if(map.get(5) < 3)
//                         return false;
//                     map.put(5, map.get(5) -3);
//                 }
//             }
//         }
//         return true;
//     }
// }